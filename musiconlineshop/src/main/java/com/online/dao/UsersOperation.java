package com.online.dao;

import com.online.data.*;
import com.online.db.DbConnection;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;

public class UsersOperation implements Users {
    @Override
    public boolean Adduser(User user) {
        boolean flag=false;
        //打开会话
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //实例infoEntitys对象
        session.save(user);
        transaction.commit();
        System.out.println("用户注册成功！");
        session.close();
        flag=true;
        return flag;
    }

    @Override
    public boolean Cancellationuser(String id, String userpasswd) {
        boolean flag=false;
        Session session= DbConnection.getSession();
        String sql="";
        if(id!=null&&userpasswd!=null) {
            sql = "select * from user WHERE userid=id AND userpasswd=userpasswd";

        }else if(id==null){
            System.out.println("用户名不能为空！");
        }else{
            System.out.println("密码不能为空！");
        }

        //session.createQuery("from User").list();
        SQLQuery query =session.createSQLQuery(sql);
        if(query!=null) {
            flag=true;
            System.out.println(" 开始注销，请稍等");
            //打开一个事务
            Transaction transaction=session.beginTransaction();
            // 用户 主键
            User user=(User)session.get(User.class, id);
//          User user =new User();
//          user.setUserid(1);
            //实例infoEntitys对象
            session.delete(user);
            transaction.commit();
            //System.out.println(user.getUsername()+" "+user.getUserpasswd());
            System.out.println(user.getUsername()+"用户注销成功！");
            flag=true;

        }else{
            System.out.println("注销失败，用户名或者密码不对！");

        }

        session.close();
        return flag;
    }

    @Override
    public boolean LoginuserCounter(String username, String userpassed) {
        boolean flag=false;
        String sql="";
        Session session= DbConnection.getSession();
        System.out.println("连接成功!");

        if(username!=null&&userpassed!=null) {
            sql = "select * from user WHERE userid=username AND userpasswd=userpassed";

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
    public List<Musicinfo> CheckallMusicinfo() {
        Session session= DbConnection.getSession();
        //查询出的结果根据id列进行反序排列
        List<Musicinfo> infolist=session.createCriteria(Musicinfo.class).addOrder(org.hibernate.criterion.Order.desc("musicinfoid")).list();
//        for(Musicinfo musicinfo:infolist){

//        }
        session.close();


        return infolist;
    }

    @Override
    public boolean AddmusicTocart(Shopcart scart) {
        boolean flag=false;
        //打开会话
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //实例infoEntitys对象
        session.save(scart);
        transaction.commit();
        System.out.println("成功添加歌曲到购物车！");
        session.close();
        flag=true;
        return flag;
    }

    @Override
    public List<Shopcart> Checkcart() {
        Session session= DbConnection.getSession();
        //查询出的结果根据id列进行反序排列
        List<Shopcart> infolist=session.createCriteria(Shopcart.class).addOrder(org.hibernate.criterion.Order.desc("userid")).list();
        session.close();
        return infolist;
    }

    /**
     *
     * 得继续优化
     * @param userid
     * @return
     */
    @Override
    public boolean DeletecartShop(String userid) {
        boolean flag=false;
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        // 用户 主键
        Shopcart shopcart=(Shopcart)session.get(Shopcart.class, Integer.parseInt(userid.trim()));
        //实例infoEntitys对象
        session.delete(shopcart);
        transaction.commit();
        System.out.println("删除购物车商品成功！");
        session.close();
        return flag;
    }

    @Override
    public boolean Deleteorder(String orderid) {
        boolean flag=false;
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        // 用户 主键
        Ordertable order=(Ordertable)session.get(Ordertable.class, orderid);
        //实例infoEntitys对象
        session.delete(order);
        transaction.commit();
        System.out.println("删除"+order.getOrderid()+"订单成功！");
        session.close();
        return flag;
    }

    @Override
    public List<Ordertable> Checkorder() {
        Session session= DbConnection.getSession();
        //查询出的结果根据id列进行反序排列
        List<Ordertable> infolist=session.createCriteria(Ordertable.class).addOrder(org.hibernate.criterion.Order.desc("orderid")).list();
        session.close();
        return infolist;
    }

    @Override
    public boolean PurchaseMusic(String userid,String musicid,String Subscribersid) {
        boolean flag=false;
        double tote=0.0;
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        System.out.println("初始化session成功");
        System.out.println("开始实例化对象");
        //实例化user对象
        //[]把user对象赋值
        //User user=new User(4,"Xiaoboluo","13856437421","male","zqr1389624316","紫薇","紫禁城","ziwei@zijinc.com");
        User user=new User();
        user.setUserid(Integer.parseInt(userid));
        //实例化musicinfo对象
        //赋值musicinfo对象[]
        Musicinfo mc=new Musicinfo();
        mc.setMusicinfoid(Integer.parseInt(musicid));
        // 实例化detall对象
        Detail dt=new Detail();
        dt.setSubscribersid(Integer.parseInt(Subscribersid));

        System.out.println("开始实例化order");
        // 实例化order对象
        Ordertable order=new Ordertable();
        order.setDetailBySubscribersid(dt);
        order.setMusicinfoByMusicinfoid(mc);
        order.setUserByUserid(user);
        //获取歌曲的单价
        // 1、得到Query对象，并写入hql语句
        Query query = session.createQuery("from Musicinfo where musicinfoid = ?");
        //2、填写上一步中占位符的内容
        query.setParameter(0, Integer.parseInt(musicid));
        //query.setParameter(1, "奶油面包");
        //3、使用Query对象的list方法得到数据集合
        List<Musicinfo> list = query.list();
        //3、遍历集合获取数据
        for (Musicinfo mcif : list) {
            tote=mcif.getMusicinfoprice();
            System.out.println(mcif);
        }
        //赋值总花费
        order.setTote(tote);
        //赋值时间
        Timestamp d = new Timestamp(System.currentTimeMillis());
        order.setOrdertime(d);
        System.out.println("实例化order成功");
        System.out.println("开始保存");
        //实例infoEntitys对象
        session.save(order);
        System.out.println("开始提交");
        transaction.commit();
        System.out.println("生成订单");
        session.close();
        //商品表中value值+1
        PurchaseMusicBymcis(musicid);
        flag=true;
        return flag;
    }

    @Override
    public boolean PurchaseMusicBymcis(String mcid) {
        boolean flag=false;
        //打开会话
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        Musicinfo mc=(Musicinfo) session.get(Musicinfo.class,Integer.parseInt(mcid));
        //修改数据
        //修改价格
        int value=mc.getMusicinfobuyvaule()+1;
        mc.setMusicinfobuyvaule(value);
        session.update(mc);
        transaction.commit();
        System.out.println("购买成功！");
        session.close();
        flag=true;
        return flag;
    }

    @Override
    public List<Musiccomments> CheckmusicComments(String musicid) {
        boolean flag=false;
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //musicinfoid
        // 1、得到Query对象，并写入hql语句
        Query query = session.createQuery("from Musiccomments where musicinfoid = ?");
        //2、填写上一步中占位符的内容
        query.setParameter(0, Integer.parseInt(musicid));
        //query.setParameter(1, "奶油面包");
        //3、使用Query对象的list方法得到数据集合
        List<Musiccomments> list = query.list();
        //3、遍历集合获取数据
        for (Musiccomments mcms : list) {
            System.out.println(mcms);
        }
        transaction.commit();
        session.close();
        flag=true;
        return list;
    }

    @Override
    public Musicinfo CheckmusicInfo(String musicid) {
        Session session= DbConnection.getSession();
        Musicinfo musicinfo=session.get(Musicinfo.class,Integer.parseInt(musicid));
        return  musicinfo;
    }

    @Override
    public List<Musicinfo> CheckallMusicINfo() {
        Session session= DbConnection.getSession();
        //查询出的结果根据id列进行反序排列
        List<Musicinfo> infolist=session.createCriteria(Musicinfo.class).addOrder(org.hibernate.criterion.Order.desc("musicinfoid")).list();
        session.close();
        return infolist;
    }

    @Override
    public boolean Comments(Musiccomments musiccomments) {
        boolean flag=false;
        //打开会话
        Session session= DbConnection.getSession();
        //打开一个事务
        Transaction transaction=session.beginTransaction();
        //实例infoEntitys对象
        Timestamp d = new Timestamp(System.currentTimeMillis());
        musiccomments.setTime(d);
        musiccomments.setId("听星");
        session.save(musiccomments);
        transaction.commit();
        System.out.println(musiccomments.getMusicinfoid()+" 评论成功！");
        session.close();
        flag=true;
        return flag;
    }
}
