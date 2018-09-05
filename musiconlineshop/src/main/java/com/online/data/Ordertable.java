package com.online.data;
;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Ordertable {
    private int orderid;
    private Double tote;
    private Timestamp ordertime;
    private Musicinfo musicinfoByMusicinfoid;
    private Detail detailBySubscribersid;
    private User userByUserid;

    public Ordertable(int orderid, Double tote, Musicinfo musicinfoByMusicinfoid, Detail detailBySubscribersid, User userByUserid,Timestamp ordertime) {
        this.orderid = orderid;
        this.tote = tote;
        this.musicinfoByMusicinfoid = musicinfoByMusicinfoid;
        this.detailBySubscribersid = detailBySubscribersid;
        this.userByUserid = userByUserid;
        this.ordertime=ordertime;
    }

    public Ordertable() {
    }

    @Id
    @Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "tote")
    public Double getTote() {
        return tote;
    }

    public void setTote(Double tote) {
        this.tote = tote;
    }

    @Basic
    @Column(name = "ordertime")
    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordertable order = (Ordertable) o;
        return orderid == order.orderid &&
                Objects.equals(tote, order.tote) &&
                Objects.equals(ordertime, order.ordertime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderid, tote, ordertime);
    }

    @ManyToOne
    @JoinColumn(name = "musicinfoid", referencedColumnName = "musicinfoid", nullable = false)
    public Musicinfo getMusicinfoByMusicinfoid() {
        return musicinfoByMusicinfoid;
    }

    public void setMusicinfoByMusicinfoid(Musicinfo musicinfoByMusicinfoid) {
        this.musicinfoByMusicinfoid = musicinfoByMusicinfoid;
    }

    @ManyToOne
    @JoinColumn(name = "subscribersid", referencedColumnName = "subscribersid", nullable = false)
    public Detail getDetailBySubscribersid() {
        return detailBySubscribersid;
    }

    public void setDetailBySubscribersid(Detail detailBySubscribersid) {
        this.detailBySubscribersid = detailBySubscribersid;
    }
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public User getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(User userByUserid) {
        this.userByUserid = userByUserid;
    }
}
