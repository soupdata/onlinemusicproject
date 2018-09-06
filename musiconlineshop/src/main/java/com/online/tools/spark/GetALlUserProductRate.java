package com.online.tools.spark;

import com.online.data.Musiccomments;
import com.online.data.Musicinfo;
import com.online.db.DbConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GetALlUserProductRate {

    public static void main(String[]args) throws IOException {
        GetMesageToFlie();
    }


    /**
     * 获取用户 商品 评分存入文件中丢给spark als
     * @throws IOException
     */
    public static void GetMesageToFlie() throws IOException {
        Session session = DbConnection.getSession();
        //查询出的结果根据id列进行反序排列.addOrder(Order.desc("musicinfobuyvaule"))
        List<Musiccomments> infolist = session.createCriteria(Musiccomments.class).list();

        FileWriter fw = new FileWriter("/home/zqr/IdeaProjects/musiconlineshop/src/main/java/com/online/tools/optfile/rating.txt");
        for (Musiccomments musiccomments : infolist) {

            System.out.println("musiccomments::" + musiccomments);
            int userid=musiccomments.getUserid();
            int musicid=musiccomments.getMusicinfoid();
            int rate=musiccomments.getMusiccommentsrate();
            fw.write(userid+" "+musicid+" "+rate+"\n");
            fw.flush();



        }
        fw.close();
        session.close();

    }
}
