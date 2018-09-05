package com.online.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Musicclassification {
    private int musicclassificationid;
    private String musicclassificationname;

    @Id
    @Column(name = "musicclassificationid")
    public int getMusicclassificationid() {
        return musicclassificationid;
    }

    public void setMusicclassificationid(int musicclassificationid) {
        this.musicclassificationid = musicclassificationid;
    }

    @Basic
    @Column(name = "musicclassificationname")
    public String getMusicclassificationname() {
        return musicclassificationname;
    }

    public void setMusicclassificationname(String musicclassificationname) {
        this.musicclassificationname = musicclassificationname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musicclassification that = (Musicclassification) o;
        return musicclassificationid == that.musicclassificationid &&
                Objects.equals(musicclassificationname, that.musicclassificationname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(musicclassificationid, musicclassificationname);
    }

    @Override
    public String toString() {
        return "Musicclassification{" +
                "musicclassificationid=" + musicclassificationid +
                ", musicclassificationname='" + musicclassificationname + '\'' +
                '}';
    }
}
