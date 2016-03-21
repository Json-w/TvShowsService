package com.jason.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Follower {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private int followerUserId;
    @Transient
    private User followingUser;
    @Transient
    private User follower;

    public Follower(int id, int userId, int followerUserId) {
        this.id = id;
        this.userId = userId;
        this.followerUserId = followerUserId;
    }

    public Follower() {
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

    public int getFollowerUserId() {
        return followerUserId;
    }

    public void setFollowerUserId(int followerUserId) {
        this.followerUserId = followerUserId;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowingUser() {
        return followingUser;
    }

    public void setFollowingUser(User followingUser) {
        this.followingUser = followingUser;
    }
}
