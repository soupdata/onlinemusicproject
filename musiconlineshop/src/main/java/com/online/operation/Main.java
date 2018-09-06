package com.online.operation;

import com.online.dao.AdminImp;
import com.online.dao.AdminOperation;
import com.online.dao.Users;
import com.online.data.*;
import com.online.dao.UsersOperation;
import com.online.data.Ordertable;
import com.online.db.DbConnection;
import com.online.tools.hadoop.HdfsUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery.*;

import java.util.List;

public class Main {
    public static void main (String []args){


        /***********************************************************************
         *添加管理员
         */

//        // 调用adminipm
//        AdminImp adminImp=new AdminOperation();
//        // 创建管理员对象
//        Administrator ad=new Administrator();
//        // 赋值
//        ad.setAdministratorid("zhouxiaobai");
//        ad.setAdministratorpasswd("123");
//        // 调用方法
//        adminImp.Addadministrator(ad);
//

        /**************************************************************************
         * 登录
         */
//
//        AdminImp adminImp=new AdminOperation();
//        adminImp.LoginadminCounter("zhouxiaobai","123");
//************************************************************************


//        Timestamp d = new Timestamp(System.currentTimeMillis());


        /**************************************************************************
         * 修改对象+主键
         */
//        AdminImp adminImp=new AdminOperation();
//        Musicinfo mu=new Musicinfo();
//        mu.setMusicinfoprice(5);
//        adminImp.ModifymusicInfo(mu,1);


        /*************************************************************************
         * 获取歌曲的评论
         */

//
//        Users users=new UsersOperation();
//        users.CheckmusicComments("1");


        /**************************************************************************
         *评论
         */
//        Users users=new UsersOperation();
//        Musiccomments cm=new Musiccomments(1,1,4,"房东的猫");
//        users.Comments(cm);
        /***************************************************************************
         *购买音乐
         */

//        Users users=new UsersOperation();
//        users.PurchaseMusic("4","1","1");




        /**××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××
         * operation hdfs
         */
        HdfsUtils hdfs=new HdfsUtils();

        try {
            hdfs.init();
            //从本地上传到hdfs
            //hdfs.upload2("/home/zqr/IdeaProjects/musiconlineshop/src/main/java/com/online/tools/optfile/rating.txt","hdfs://localhost:9000/input");
            //删除hdfs里文件或目录
            //hdfs.remove("hdfs://localhost:9000/output",false);
            //从hdfs下载文件到本地
            hdfs.download("hdfs://localhost:9000/output","/home/zqr/IdeaProjects/musiconlineshop/src/main/java/com/online/tools/optfile/output");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
