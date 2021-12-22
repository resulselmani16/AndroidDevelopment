package com.cacttuseducation_21_22.models;

public class RvModel {
    private int image;
    private String title;

    public RvModel(String title,int image) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
