package com.online.tools.spark;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel;
import scala.Tuple2;
import org.apache.spark.mllib.recommendation.ALS;
import org.apache.spark.mllib.recommendation.Rating;

import java.io.Serializable;

public class ALSDealData implements Serializable {


    /**
     * 在这之前需要获取所有用户的购买商品user xx1 xx2 xx3
     * 通过用户id获取用户购买过的歌曲
     * 评分系统String userid
     */
    public static void main(String []args) {
        // Logger.getLogger("org").setLevel(Level.ERROR);

//        Logger.getLogger("org.apache.spark").setLevel(Level.WARN);
//        Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF);
//        if (args.length != 2) {
//
//            System.out.println("Usage: /path/to/spark/bin/spark-submit --driver-memory 2g --class week7.MovieLensALS " +
//
//                    "week7.jar movieLensHomeDir personalRatingsFile");
//
//            System.exit(1);
//
//        }
        /**
         * 第1步：创建Spark的配置对象SparkConf，设置Spark程序的运行时的配置信息，
         * 例如说通过setMaster来设置程序要链接的Spark集群的Master的URL,如果设置
         * 为local，则代表Spark程序在本地运行，特别适合于机器配置条件非常差（例如 只有1G的内存）的初学者 *
         */
        SparkConf conf = new SparkConf().setAppName("Spark WordCount written by Java").setMaster("local");
        /**
         * 第2步：创建SparkContext对象
         * SparkContext是Spark程序所有功能的唯一入口，无论是采用Scala、Java、Python
         * 、R等都必须有一个SparkContext(不同的语言具体的类名称不同，如果是Java的话则为JavaSparkContext)
         * SparkContext核心作用：初始化Spark应用程序运行所需要的核心组件，包括DAGScheduler、TaskScheduler、
         * SchedulerBackend 同时还会负责Spark程序往Master注册程序等
         * SparkContext是整个Spark应用程序中最为至关重要的一个对象
         */
        JavaSparkContext jsc = new JavaSparkContext(conf); // 其底层实际上就是Scala的SparkContext
        //=============================================================================================

        // 加载并解析数据
        String path = "/home/zqr/IdeaProjects/musiconlineshop/src/main/java/com/online/tools/optfile/rating.txt";
        JavaRDD<String> data = jsc.textFile(path);
        JavaRDD<Rating> ratings = data.map(s -> {
            String[] sarray = s.split(" ");
            return new Rating(Integer.parseInt(sarray[0]),
                    Integer.parseInt(sarray[1]),
                    Double.parseDouble(sarray[2]));
        });

        /**
         * 输出map组织的数据
         */
        System.out.println("输出map对：");
        ratings.collect().forEach(System.out::println);

        /**
         *使用ALS 构建推荐模型
         */
        // 隐性因子个数
        int rank = 10;
        //迭代次数
        int numIterations = 10;
        //lambda是ALS的正则化参数；
        MatrixFactorizationModel model = ALS.train(JavaRDD.toRDD(ratings), rank, numIterations, 0.01);

        System.out.println("model:" + model);

        // 评估评级数据模型
        JavaRDD<Tuple2<Object, Object>> userProducts =
                ratings.map(r -> new Tuple2<>(r.user(), r.product()));

        JavaPairRDD<Tuple2<Integer, Integer>, Double> predictions = JavaPairRDD.fromJavaRDD(
                model.predict(JavaRDD.toRDD(userProducts)).toJavaRDD()
                        .map(r -> new Tuple2<>(new Tuple2<>(r.user(), r.product()), r.rating()))
        );

        System.out.println("打印predictions的值");
        predictions.collect().forEach(System.out::println);


        JavaRDD<Tuple2<Double, Double>> ratesAndPreds = JavaPairRDD.fromJavaRDD(
                ratings.map(r -> new Tuple2<>(new Tuple2<>(r.user(), r.product()), r.rating())))
                .join(predictions).values();


        System.out.println("打印ratesAndPreds的值");
        ratesAndPreds.collect().forEach(System.out::println);


        double MSE = ratesAndPreds.mapToDouble(pair -> {
            double err = pair._1() - pair._2();
            return err * err;
        }).mean();
        System.out.println("Mean Squared Error = " + MSE);

        // 保存并加载模型
        model.save(jsc.sc(), "target/tmp/myCollaborativeFilter");
        MatrixFactorizationModel sameModel = MatrixFactorizationModel.load(jsc.sc(),
                "target/tmp/myCollaborativeFilter");


    }
}













