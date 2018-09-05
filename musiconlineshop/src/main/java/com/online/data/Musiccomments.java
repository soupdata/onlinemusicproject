package com.online.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Musiccomments {
    private String musiccomments;
    private Timestamp time;
    private int userid;
    private int musicinfoid;
    private int musiccommentsrate;

    public Musiccomments( int userid, int musicinfoid, int musiccommentsrate,String musiccomments) {
        this.musiccomments = musiccomments;
        this.userid = userid;
        this.musicinfoid = musicinfoid;
        this.musiccommentsrate = musiccommentsrate;
    }

    public Musiccomments() {
    }


    @Basic
    @Column(name = "musiccomments")
    public String getMusiccomments() {
        return musiccomments;
    }

    public void setMusiccomments(String musiccomments) {
        this.musiccomments = musiccomments;
    }
    @Basic
    @Column(name = "musiccommentsrate")
    public int getMusiccommentsrate() {
        return musiccommentsrate;
    }

    public void setMusiccommentsrate(int musiccommentsrate) {
        this.musiccommentsrate = musiccommentsrate;
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
        Musiccomments that = (Musiccomments) o;
        return Objects.equals(musiccomments, that.musiccomments) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(musiccomments, time);
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMusicinfoid() {
        return musicinfoid;
    }

    public void setMusicinfoid(int musicinfoid) {
        this.musicinfoid = musicinfoid;
    }

    @Override
    public String toString() {
        return "Musiccomments{" +
                "musiccomments='" + musiccomments + '\'' +
                ", time=" + time +
                ", userid=" + userid +
                ", musicinfoid=" + musicinfoid +
                ", musiccommentsrate=" + musiccommentsrate +
                ", id='" + id + '\'' +
                '}';
    }
}
