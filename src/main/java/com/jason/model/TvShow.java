package com.jason.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tv_shows")
public class TvShow {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date showTime;
    private String showPlatform;
    private String type;
    private String originName;
    private String picture;
    @Type(type = "text")
    private String introduction;
    @Type(type = "text")
    private String comments;


    public TvShow() {
    }

    public TvShow(String comments, int id, String introduction, String name, String originName, String picture, String showPlatform, Date showTime, String type) {
        this.comments = comments;
        this.id = id;
        this.introduction = introduction;
        this.name = name;
        this.originName = originName;
        this.picture = picture;
        this.showPlatform = showPlatform;
        this.showTime = showTime;
        this.type = type;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getShowPlatform() {
        return showPlatform;
    }

    public void setShowPlatform(String showPlatform) {
        this.showPlatform = showPlatform;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
