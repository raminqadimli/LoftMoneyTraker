package com.example.user.loftmoneytraker;

/**
 * Created by Admin on 03-May-15.
 */
public class Category {
    private String name;
    private int image;

    public Category(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
