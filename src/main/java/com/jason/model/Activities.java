package com.jason.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Activities {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private String content;
    @Column(name = "picture")
    private String picUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseTime;

    public Activities() {
    }

    public Activities(int id, int userId, String content, String picUrl, Date releaseTime) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.picUrl = picUrl;
        this.releaseTime = releaseTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}
