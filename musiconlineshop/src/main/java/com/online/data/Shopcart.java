package com.online.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Shopcart {


    private Musicinfo musicinfoByMusicinfoid;

    @ManyToOne
    @JoinColumn(name = "musicinfoid", referencedColumnName = "musicinfoid", nullable = false)
    public Musicinfo getMusicinfoByMusicinfoid() {
        return musicinfoByMusicinfoid;
    }

    public void setMusicinfoByMusicinfoid(Musicinfo musicinfoByMusicinfoid) {
        this.musicinfoByMusicinfoid = musicinfoByMusicinfoid;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Shopcart{" +
                "musicinfoByMusicinfoid=" + musicinfoByMusicinfoid +
                ", id='" + id + '\'' +
                '}';
    }
}
