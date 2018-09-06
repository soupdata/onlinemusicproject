package com.online.tools.hadoop;

import com.online.data.Musiccomments;
import com.online.db.DbConnection;
import com.online.tools.ansj.AnsjTest;
import org.hibernate.Session;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GetAllCommentsToFile {


    public static void main (String[]args) throws IOException {
        CommentsToFile();
    }

    public static void CommentsToFile() throws IOException {
        Session session = DbConnection.getSession();
        //查询出的结果根据id列进行反序排列.addOrder(Order.desc("musicinfobuyvaule"))
        List<Musiccomments> infolist = session.createCriteria(Musiccomments.class).list();

        FileWriter fw = new FileWriter("/home/zqr/IdeaProjects/musiconlineshop/src/main/java/com/online/tools/optfile/comments.txt");
        for (Musiccomments musiccomments : infolist) {

            System.out.println("musiccomments::" + musiccomments);
            String commten=musiccomments.getMusiccomments();
            AnsjTest ansj=new AnsjTest();
            String commtens=ansj.test(commten);
            fw.write(commtens+"\n");
            fw.flush();



        }
        fw.close();
        session.close();

    }
}
