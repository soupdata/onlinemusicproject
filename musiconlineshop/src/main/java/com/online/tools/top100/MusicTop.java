package com.online.tools.top100;

import com.online.data.Musicinfo;
import com.online.db.DbConnection;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class MusicTop {
    int TOP=10;
    int count=0;
    public  void musictop() {

    Session session = DbConnection.getSession();
    //查询出的结果根据id列进行反序排列
    List<Musicinfo> infolist = session.createCriteria(Musicinfo.class).addOrder(Order.desc("musicinfobuyvaule")).list();
    for (Musicinfo musicinfo : infolist) {
         count++;
        System.out.println("输出购买次数：" + musicinfo.getMusicinfobuyvaule());
        System.out.println("输出音乐名：" + musicinfo.getMusicinfoname());
        if(count==TOP){
            break;
        }
    }

    session.close();
     }

}
