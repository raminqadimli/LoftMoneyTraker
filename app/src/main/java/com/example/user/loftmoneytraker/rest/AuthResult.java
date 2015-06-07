package com.example.user.loftmoneytraker.rest;

/**
 * Created by user on 03.06.2015.
 */
public class AuthResult extends Result {
    private int id;
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public int getId() {
        return id;
    }

}
