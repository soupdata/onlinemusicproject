package com.online.dao;

import com.online.data.*;

import java.util.List;

public interface Users {

    /**
     * 添加一个用户，用户注册
     * @param user
     * @return
     */
    public boolean Adduser(User user);

    /**
     * 用户注销自己的账户
     * @param username
     * @param userpasswd
     * @return
     */
    public boolean Cancellationuser(String username,String userpasswd);

    /**
     * 登录用户
     * @param username
     * @param userpassed
     * @return
     */
    public boolean LoginuserCounter(String username,String userpassed);

    /**
     * 查看所有歌曲
     * @return
     */
    public List<Musicinfo> CheckallMusicinfo();

    /**
     * 添加歌曲到购物车
     * @param scart
     * @return
     */
    public boolean AddmusicTocart(Shopcart scart);

    /**
     * 用户查看购物车
     * @return
     */
    public List<Shopcart> Checkcart();

    /**
     * 根据订单号和用户id删除购物车中的物品（将数量减少为0）
     * @param userid
     * @return
     */
    public boolean DeletecartShop(String userid);

    /**
     * 根据订单号删除订单
     * @param orderid
     * @return
     */
    public boolean Deleteorder(String orderid);

    /**
     * 用户查看订单
     * @return
     */
    public List<Ordertable> Checkorder();

    /**
     * 购买歌曲
     * @param musicid
     * @return
     */
    public boolean PurchaseMusic(String userid,String musicid,String Subscribersid);
    public boolean PurchaseMusicBymcis(String mcid);

    /**
     * 查看歌曲的评论
     * @param musicid
     * @return
     */
    public List<Musiccomments>CheckmusicComments(String musicid);

    /**
     * 查看歌曲的信息
     * @param musicid
     * @return
     */
    public Musicinfo CheckmusicInfo(String musicid);

    /**
     * 查看所有的音乐
     * @return
     */
    public  List<Musicinfo> CheckallMusicINfo();

    /**
     * 评论
     * String userid,String musicid,String comments,String rate
     */
    public boolean Comments(Musiccomments musiccomments);



}
