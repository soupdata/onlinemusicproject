package com.online.dao;

import com.online.data.Administrator;
import com.online.data.Musicinfo;
import com.online.data.User;
import com.online.db.DbConnection;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.util.List;

public class AdminOperation implements AdminImp {
    @Override
    public boolean Addadministrator(Administrator admin) {
        boolean flag=false;
        //将获取到的数据保存到数据库
        //打开会话
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //实例infoEntitys对象
        session.save(admin);
        transaction.commit();
        System.out.println("注册管理员账户成功！");
        session.close();
        flag=true;
        return flag;
    }

    @Override
    public boolean LoginadminCounter(String username, String userpasswd) {
        boolean flag=false;
        String sql="";
        Session session= DbConnection.getSession();
        System.out.println("连接成功!");

        if(username!=null&&userpasswd!=null) {
            sql = "select * from user WHERE userid=username AND userpasswd=userpasswd";

        }else if(username==null){
            System.out.println("用户名不能为空！");
        }else{
            System.out.println("密码不能为空！");
        }

        //session.createQuery("from User").list();
        SQLQuery query =session.createSQLQuery(sql);
        if(query!=null) {
            flag=true;
            System.out.println("登录成功，欢迎您："+username);

        }else{
            System.out.println("登录失败，用户名或者密码不对！");
        }

        return flag;
    }

    @Override
    public boolean Addmusic(Musicinfo musicinfo) {
        boolean flag=false;
        //将获取到的数据保存到数据库
        //打开会话
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //实例infoEntitys对象
        session.save(musicinfo);
        transaction.commit();
        System.out.println("添加歌曲成功！");
        session.close();
        flag=true;
        return flag;
    }

    @Override
    public boolean Cancellationadmin(Administrator admin) {
        boolean flag=false;
        //将获取到的数据保存到数据库
        //打开会话
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //实例infoEntitys对象
        session.delete(admin);
        transaction.commit();
        System.out.println("注销管理员账户成功");
        session.close();
        flag=true;
        return flag;
    }

    @Override
    public boolean DeletemusicfromId(String musicid) {
        boolean flag=false;
        //将获取到的数据保存到数据库
        //打开会话

        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        Musicinfo musicinfo=(Musicinfo)session.get(Musicinfo.class, musicid);
        //实例infoEntitys对象
        session.delete(musicinfo);
        transaction.commit();
        System.out.println("删除"+musicinfo.getMusicinfoname()+"歌曲成功！");
        session.close();
        flag=true;
        return flag;
    }

    @Override
    public boolean DeleteuserfromId(String id) {
        boolean flag=false;
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        // 用户 主键
        User user=(User)session.get(User.class, id);
//        User user =new User();
//        user.setUserid(1);
        //实例infoEntitys对象
        session.delete(user);
        transaction.commit();
        //System.out.println(user.getUsername()+" "+user.getUserpasswd());
        System.out.println("删除"+user.getUsername()+"用户成功！");
        session.close();
        return flag;

    }

    @Override
    public boolean ModifymusicInfo(Musicinfo musicinfo,Integer prk) {
        boolean flag=false;
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //加载要修改的数据
        musicinfo=(Musicinfo)session.get(Musicinfo.class,prk);
        //修改数据
        //修改价格
        musicinfo.setMusicinfoprice(12);
        session.update(musicinfo);
        transaction.commit();
        System.out.println("信息修改成功！");
        session.close();
        flag=true;
        return flag;
    }


    @Override
    public boolean ModifyadminPasswd(String newpasswd,String prk) {
        boolean flag=false;
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //加载要修改的数据
        Administrator admin=(Administrator) session.get(Administrator.class,prk);
        //修改数据
        //修改价格
        admin.setAdministratorpasswd(newpasswd);
        session.update(admin);
        transaction.commit();
        System.out.println("修改密码成功！");
        session.close();
        flag=true;
        return flag;
    }

    @Override
    public List<User> Chekalluser() {
        Session session= DbConnection.getSession();
        //查询出的结果根据id列进行反序排列
        List<User> infolist=session.createCriteria(User.class).addOrder(Order.desc("userid")).list();
        for(User user:infolist){
            System.out.println(user.getRegistertime());
            System.out.println(user.getUsername());
            System.out.println(user.getUserid());
        }
        session.close();


        return infolist;
    }
}
