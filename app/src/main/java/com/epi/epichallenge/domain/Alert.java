package com.epi.epichallenge.domain;

public class Alert {
    private int id ;
    private String name;
    private String imgURL;
    private String vidURL;
    private User user;

    public Alert() {
    }

    public Alert(int id, String name, String imgURL, String vidURL, User user) {
        this.id = id;
        this.name = name;
        this.imgURL = imgURL;
        this.vidURL = vidURL;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getVidURL() {
        return vidURL;
    }

    public void setVidURL(String vidURL) {
        this.vidURL = vidURL;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
