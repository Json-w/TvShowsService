package com.jason.model;

import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseTime;
    @Transient
    private User user;

    public Activities() {
    }

    public Activities(int id, int userId, String content, String picUrl, Date releaseTime, User user) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.picUrl = picUrl;
        this.releaseTime = releaseTime;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
