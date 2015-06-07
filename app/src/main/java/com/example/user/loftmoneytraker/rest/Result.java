package com.example.user.loftmoneytraker.rest;

import android.text.TextUtils;

/**
 * Created by user on 03.06.2015.
 */
public class Result {
    String status;

    public boolean isSuccess() {
        return TextUtils.equals(status, "success");
    }
}
