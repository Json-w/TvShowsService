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

}
