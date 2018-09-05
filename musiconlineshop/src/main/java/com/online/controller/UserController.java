package com.online.controller;



import com.online.data.User;
import com.online.db.DbConnection;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
//    @RequestMapping(value = "/users",method = RequestMethod.GET)
//
//    public String listuser(ModelMap map){
//          Session session= DbConnection.getSession();
////        System.out.println("连接成功！！！！！");
////        //查询出的结果根据id列进行反序排列
////        //StringBuffer sql=new StringBuffer();
////        //sql.append(" SELECT * FROM `user`; ");
//        //String sql="delete from user where userid='1'";
////        session.delete(sql);
////
////        List<User> userlist=null;
//        //SQLQuery query =session.createSQLQuery(sql);
////        if(query!=null) {
////            System.out.println("query不为空");
////             userlist= query.list();
////        }
////
////        //      使用forEach遍历集合
////        for(User user:userlist){
////            System.out.println(user.getRegistertime());
////            System.out.println(user.getUsername());
////            System.out.println(user.getUserid());
////        }
////
////            System.out.println(userlist);
////将获取到的数据保存到数据库
////        //打开会话
////        Session session= DbConnection.getSession();
////        //打开一个事务
////        Transaction transaction=session.beginTransaction();
//////        //实例infoEntitys对象
//////        User user=new User();
//////        user.setUserid(1);
////        session.delete(sql);
////        transaction.commit();
////        System.out.println("删除用户成功！");
//        //session.close();
//
//        //Session session= DbConnection.getSession();
//        //查询出的结果根据id列进行反序排列
//        List<User> infolist=session.createCriteria(User.class).addOrder(Order.desc("userid")).list();
//        map.addAttribute("users",infolist);
//        for(User user:infolist){
//            System.out.println(user.getRegistertime());
//            System.out.println(user.getUsername());
//            System.out.println(user.getUserid());
//        }
//        session.close();
//
//                //session.createCriteria(User.class).addOrder(Order.desc("userid")).list();
////        map.addAttribute("users",userlist);
////        session.close();
//        return "users";
//    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    //, @RequestParam String name, @RequestParam String sex, HttpServletRequest request, HttpServletResponse response
    public String rusult(ModelMap map) {
//        map.addAttribute("name",name);
//        map.addAttribute("sex",sex);
        //将获取到的数据保存到数据库
        //打开会话
        Session session=DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //实例infoEntitys对象
        User user=new User();
        user.setUsersex("male");
        user.setUsername("胡歌gg");
        user.setUseremail("hugeshanghai@lxy");
        user.setUserrealname("胡歌");
        user.setUseraddress("上海市");
        user.setUserpasswd("123");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());
        Timestamp ts=Timestamp.valueOf(date);
        user.setRegistertime(ts);
        System.out.println();// new Date()为获取当前系统时间
        session.save(user);
        transaction.commit();
        session.close();
        return "users";
    }


//    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
//    public String adduser(ModelMap map) {
////        InfoEntity info=new InfoEntity();
////        info.setAge(20);
////        info.setName("zyb");
////        //排除为空，空报异常
////        map.addAttribute("info",info);
//        User user=new User();
//        user.setAge(20);
//        user.setName("zyb");
//        //排除为空，空报异常
//        map.addAttribute("user",user);
//        return "add_user";
//    }
}
