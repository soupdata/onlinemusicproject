package com.online.data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Musicinfo {


    private int musicinfoid;
    private String musicinfoname;
    private String musicinfosinger;
    private String musicinfoalbumcover;
    private double musicinfoprice;
    private Integer musicinfobuyvaule;
    private Integer musicinfocolcmvalue;
    private String musicinfolyrics;
    private Timestamp musicinfosjtime;
    private Musicclassification musicclassificationByMusicclassificationid;

    public Musicinfo(int musicinfoid, String musicinfoname, String musicinfosinger, String musicinfoalbumcover, double musicinfoprice, Integer musicinfobuyvaule, Integer musicinfocolcmvalue, String musicinfolyrics, Musicclassification musicclassificationByMusicclassificationid,Timestamp musicinfosjtime) {
        this.musicinfoid = musicinfoid;
        this.musicinfoname = musicinfoname;
        this.musicinfosinger = musicinfosinger;
        this.musicinfoalbumcover = musicinfoalbumcover;
        this.musicinfoprice = musicinfoprice;
        this.musicinfobuyvaule = musicinfobuyvaule;
        this.musicinfocolcmvalue = musicinfocolcmvalue;
        this.musicinfolyrics = musicinfolyrics;
        this.musicclassificationByMusicclassificationid = musicclassificationByMusicclassificationid;
        this.musicinfosjtime=musicinfosjtime;
    }

    public Musicinfo() {
    }


    @Id
    @Column(name = "musicinfoid")
    public int getMusicinfoid() {
        return musicinfoid;
    }

    public void setMusicinfoid(int musicinfoid) {
        this.musicinfoid = musicinfoid;
    }

    @Basic
    @Column(name = "musicinfoname")
    public String getMusicinfoname() {
        return musicinfoname;
    }

    public void setMusicinfoname(String musicinfoname) {
        this.musicinfoname = musicinfoname;
    }

    @Basic
    @Column(name = "musicinfosinger")
    public String getMusicinfosinger() {
        return musicinfosinger;
    }

    public void setMusicinfosinger(String musicinfosinger) {
        this.musicinfosinger = musicinfosinger;
    }

    @Basic
    @Column(name = "musicinfoalbumcover")
    public String getMusicinfoalbumcover() {
        return musicinfoalbumcover;
    }

    public void setMusicinfoalbumcover(String musicinfoalbumcover) {
        this.musicinfoalbumcover = musicinfoalbumcover;
    }

    @Basic
    @Column(name = "musicinfoprice")
    public double getMusicinfoprice() {
        return musicinfoprice;
    }

    public void setMusicinfoprice(double musicinfoprice) {
        this.musicinfoprice = musicinfoprice;
    }

    @Basic
    @Column(name = "musicinfobuyvaule")
    public Integer getMusicinfobuyvaule() {
        return musicinfobuyvaule;
    }

    public void setMusicinfobuyvaule(Integer musicinfobuyvaule) {
        this.musicinfobuyvaule = musicinfobuyvaule;
    }

    @Basic
    @Column(name = "musicinfocolcmvalue")
    public Integer getMusicinfocolcmvalue() {
        return musicinfocolcmvalue;
    }

    public void setMusicinfocolcmvalue(Integer musicinfocolcmvalue) {
        this.musicinfocolcmvalue = musicinfocolcmvalue;
    }

    @Basic
    @Column(name = "musicinfolyrics")
    public String getMusicinfolyrics() {
        return musicinfolyrics;
    }

    public void setMusicinfolyrics(String musicinfolyrics) {
        this.musicinfolyrics = musicinfolyrics;
    }

    @Basic
    @Column(name = "musicinfosjtime")
    public Timestamp getMusicinfosjtime() {
        return musicinfosjtime;
    }

    public void setMusicinfosjtime(Timestamp musicinfosjtime) {
        this.musicinfosjtime = musicinfosjtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musicinfo musicinfo = (Musicinfo) o;
        return musicinfoid == musicinfo.musicinfoid &&
                Double.compare(musicinfo.musicinfoprice, musicinfoprice) == 0 &&
                Objects.equals(musicinfoname, musicinfo.musicinfoname) &&
                Objects.equals(musicinfosinger, musicinfo.musicinfosinger) &&
                Objects.equals(musicinfoalbumcover, musicinfo.musicinfoalbumcover) &&
                Objects.equals(musicinfobuyvaule, musicinfo.musicinfobuyvaule) &&
                Objects.equals(musicinfocolcmvalue, musicinfo.musicinfocolcmvalue) &&
                Objects.equals(musicinfolyrics, musicinfo.musicinfolyrics) &&
                Objects.equals(musicinfosjtime, musicinfo.musicinfosjtime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(musicinfoid, musicinfoname, musicinfosinger, musicinfoalbumcover, musicinfoprice, musicinfobuyvaule, musicinfocolcmvalue, musicinfolyrics, musicinfosjtime);
    }

    @ManyToOne
    @JoinColumn(name = "musicclassificationid", referencedColumnName = "musicclassificationid")
    public Musicclassification getMusicclassificationByMusicclassificationid() {
        return musicclassificationByMusicclassificationid;
    }

    public void setMusicclassificationByMusicclassificationid(Musicclassification musicclassificationByMusicclassificationid) {
        this.musicclassificationByMusicclassificationid = musicclassificationByMusicclassificationid;
    }

    @Override
    public String toString() {
        return "Musicinfo{" +
                "musicinfoid=" + musicinfoid +
                ", musicinfoname='" + musicinfoname + '\'' +
                ", musicinfosinger='" + musicinfosinger + '\'' +
                ", musicinfoalbumcover='" + musicinfoalbumcover + '\'' +
                ", musicinfoprice=" + musicinfoprice +
                ", musicinfobuyvaule=" + musicinfobuyvaule +
                ", musicinfocolcmvalue=" + musicinfocolcmvalue +
                ", musicinfolyrics='" + musicinfolyrics + '\'' +
                ", musicinfosjtime=" + musicinfosjtime +
                ", musicclassificationByMusicclassificationid=" + musicclassificationByMusicclassificationid +
                '}';
    }
}
