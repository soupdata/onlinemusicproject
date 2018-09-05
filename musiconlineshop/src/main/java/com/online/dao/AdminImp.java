package com.online.dao;

import com.online.data.Administrator;
import com.online.data.Musicinfo;
import com.online.data.User;

import java.util.List;

public interface AdminImp {


    /**
     * 添加管理员帐号（注册管理员帐号）
     * @param admin
     * @return
     */
    public  boolean Addadministrator(Administrator admin);

    /**
     * 管理员自身登录帐号
     * @param username
     * @param userpasswd
     * @return
     */
    public boolean LoginadminCounter(String username,String userpasswd);


    /**
     * 管理员添加歌曲
     * @param musicinfo
     * @return
     */
    public boolean Addmusic(Musicinfo musicinfo);

    /**
     * 注销管理员账户
     * @param admin
     * @return
     */
    public boolean Cancellationadmin(Administrator admin);

    /**
     * 管理员根据歌曲的id删除单首歌曲
     * @param musicid
     * @return
     */
    public boolean DeletemusicfromId(String musicid);

    /**
     * 管理员根据歌曲的名字删除单首歌曲
     //* @param musicname
     * @return
     */
    //public boolean DeletemusicfromName(String musicname);

    /**
     * 管理员删除一个用户
     * @param id
     * @return
     */
    public boolean DeleteuserfromId(String id);

    /**
     * 管理员修改歌曲的信息
     * @param musicinfo
     * @return
     */
    public boolean ModifymusicInfo(Musicinfo musicinfo,Integer prk);

    /**
     * 管理员修改自身的密码
     * @param newpasswd
     * @return
     */
    public boolean ModifyadminPasswd(String newpasswd,String prk);

    /**
     * 查看所有的用户信息
     * @return
     */
    public List<User> Chekalluser();







}
