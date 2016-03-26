package com.jason.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Comments {
    @Id
    @GeneratedValue
    private int id;
    private int activityId;
    @Type(type = "text")
    private String commentContent;
    private int commentUserId;
    @Transient
    private User commentUser;

    public Comments() {
    }

    public Comments(int id, int activityId, String commentContent, int commentUserId) {
        this.id = id;
        this.activityId = activityId;
        this.commentContent = commentContent;
        this.commentUserId = commentUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public User getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }
}
