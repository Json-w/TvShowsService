package com.jason.model;

import javax.persistence.Entity;

@Entity
public class User {

    private int id;
    private String username;
    private String password;
    private int chooseTvShowId;
    private int activitiesId;
    private int follwerId;


}
