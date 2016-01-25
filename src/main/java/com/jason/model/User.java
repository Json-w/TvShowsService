package com.jason.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private int chooseTvShowId;
    private int activitiesId;
    private int follwerId;

    public User(int id, String username, String password, int chooseTvShowId, int activitiesId, int follwerId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.chooseTvShowId = chooseTvShowId;
        this.activitiesId = activitiesId;
        this.follwerId = follwerId;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getChooseTvShowId() {
        return chooseTvShowId;
    }

    public void setChooseTvShowId(int chooseTvShowId) {
        this.chooseTvShowId = chooseTvShowId;
    }

    public int getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(int activitiesId) {
        this.activitiesId = activitiesId;
    }

    public int getFollwerId() {
        return follwerId;
    }

    public void setFollwerId(int follwerId) {
        this.follwerId = follwerId;
    }
}
