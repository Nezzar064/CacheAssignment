package com.example.demo.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;

public class User {

    private long userId;
    private String gigaText;

    public User() {
    }

    public User(long userId, String gigaText) {
        this.userId = userId;
        this.gigaText = gigaText;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getGigaText() {
        return gigaText;
    }

    public void setGigaText(String gigaText) {
        this.gigaText = gigaText;
    }

}
