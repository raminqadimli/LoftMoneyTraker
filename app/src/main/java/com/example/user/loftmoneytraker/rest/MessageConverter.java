package com.example.user.loftmoneytraker.rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * Created by user on 03.06.2015.
 */
public class MessageConverter extends GsonHttpMessageConverter {
    public MessageConverter() {
        setGson(new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd")
                .create());
    }
}
