package com.theocho.youflix.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Profile {


    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private ArrayList<Video> videos;

    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
        this.videos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}
