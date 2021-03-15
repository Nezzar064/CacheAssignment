package com.example.demo.service;

import com.example.demo.models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@CacheConfig(cacheNames = {"user"})
public class UserServiceImpl implements UserService {

    //Makes method cacheable, by CacheName "user", as set in @CacheConfig

    @Cacheable
    @Override
    public User findUserById(long id) throws InterruptedException {
        return getUserData(id);
    }

    //Used for creating a user

    private User getUserData(long id) throws InterruptedException {
        return new User(id, getDataSlow());
    }

    //Simulates a slow call and returns 200 random characters

    private String getDataSlow() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return RandomStringUtils.randomAlphabetic(200);
    }
}
