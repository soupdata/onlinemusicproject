package com.online.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Detail {


    private int subscribersid;
    private String paymethod;
    private Timestamp time;

    public Detail(int subscribersid, String paymethod,Timestamp time) {
        this.subscribersid = subscribersid;
        this.paymethod = paymethod;
        this.time=time;
    }

    public Detail() {
    }

    @Id
    @Column(name = "subscribersid")
    public int getSubscribersid() {
        return subscribersid;
    }

    public void setSubscribersid(int subscribersid) {
        this.subscribersid = subscribersid;
    }

    @Basic
    @Column(name = "paymethod")
    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return subscribersid == detail.subscribersid &&
                Objects.equals(paymethod, detail.paymethod) &&
                Objects.equals(time, detail.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subscribersid, paymethod, time);
    }
    @Override
    public String toString() {
        return "Detail{" +
                "subscribersid=" + subscribersid +
                ", paymethod='" + paymethod + '\'' +
                ", time=" + time +
                '}';
    }
}
