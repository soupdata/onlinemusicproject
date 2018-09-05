package com.online.operation;

import com.online.dao.AdminImp;
import com.online.dao.AdminOperation;
import com.online.dao.Users;
import com.online.data.*;
import com.online.dao.UsersOperation;
import com.online.data.Ordertable;
import com.online.db.DbConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery.*;

import java.util.List;

public class Main {
    public static void main (String []args){


        /***********************************************************************
         *
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
//
//
//
//        AdminImp adminImp=new AdminOperation();
//        adminImp.LoginadminCounter("zhouxiaobai","123");
//************************************************************************
//        AdminImp adminImp=new AdminOperation();
//        Musicinfo mu=new Musicinfo();
//        mu.setMusicinfoprice(5);
//        adminImp.ModifymusicInfo(mu,1);

//        Timestamp d = new Timestamp(System.currentTimeMillis());


        /**************************************************************************
         * 修改对象+主键
         */



        /*************************************************************************
         * 获取歌曲的评论
         */



        /**************************************************************************
         *
         */

        //购买音乐
//        Users users=new UsersOperation();
//        users.PurchaseMusic("4","1","1");
        Users users=new UsersOperation();
        Musiccomments cm=new Musiccomments(1,1,4,"房东的猫");
        users.Comments(cm);
















    }
}
