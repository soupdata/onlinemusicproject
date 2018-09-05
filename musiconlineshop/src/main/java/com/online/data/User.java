package com.online.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class User {
    private int userid;
    private String username;
    private String usercall;
    private String usersex;
    private String userpasswd;
    private String userrealname;
    private String useraddress;
    private String useremail;
    private Timestamp registertime;

    public User(int userid, String username, String usercall, String usersex, String userpasswd, String userrealname, String useraddress, String useremail,Timestamp registertime) {
        this.userid = userid;
        this.username = username;
        this.usercall = usercall;
        this.usersex = usersex;
        this.userpasswd = userpasswd;
        this.userrealname = userrealname;
        this.useraddress = useraddress;
        this.useremail = useremail;
        this.registertime=registertime;
    }

    public User() {
    }

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "usercall")
    public String getUsercall() {
        return usercall;
    }

    public void setUsercall(String usercall) {
        this.usercall = usercall;
    }

    @Basic
    @Column(name = "usersex")
    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    @Basic
    @Column(name = "userpasswd")
    public String getUserpasswd() {
        return userpasswd;
    }

    public void setUserpasswd(String userpasswd) {
        this.userpasswd = userpasswd;
    }

    @Basic
    @Column(name = "userrealname")
    public String getUserrealname() {
        return userrealname;
    }

    public void setUserrealname(String userrealname) {
        this.userrealname = userrealname;
    }

    @Basic
    @Column(name = "useraddress")
    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    @Basic
    @Column(name = "useremail")
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Basic
    @Column(name = "registertime")
    public Timestamp getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Timestamp registertime) {
        this.registertime = registertime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userid == user.userid &&
                Objects.equals(username, user.username) &&
                Objects.equals(usercall, user.usercall) &&
                Objects.equals(usersex, user.usersex) &&
                Objects.equals(userpasswd, user.userpasswd) &&
                Objects.equals(userrealname, user.userrealname) &&
                Objects.equals(useraddress, user.useraddress) &&
                Objects.equals(useremail, user.useremail) &&
                Objects.equals(registertime, user.registertime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userid, username, usercall, usersex, userpasswd, userrealname, useraddress, useremail, registertime);
    }
    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", usercall='" + usercall + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userpasswd='" + userpasswd + '\'' +
                ", userrealname='" + userrealname + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", useremail='" + useremail + '\'' +
                ", registertime=" + registertime +
                '}';
    }
}
