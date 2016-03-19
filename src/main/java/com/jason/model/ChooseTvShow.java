package com.jason.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChooseTvShow {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private String tvShowName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime;

    public ChooseTvShow() {
    }

    public ChooseTvShow(int id, int userId, String tvShowName, Date addTime) {
        this.id = id;
        this.userId = userId;
        this.tvShowName = tvShowName;
        this.addTime = addTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTvShowName() {
        return tvShowName;
    }

    public void setTvShowName(String tvShowName) {
        this.tvShowName = tvShowName;
    }
}
