package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserCache implements CacheService {

    //BIG DATA IS THE ROOT OF ALL EVIL, BUT I AM EVIL

    Map<Long, String> cacheDB = new HashMap<>();


    @Override
    public String get(Long key) {
        return cacheDB.get(key);
    }

    @Override
    public void save(Long key, String value) {
        cacheDB.put(key, value);

    }

    @Override
    public boolean has(Long key) {
        return cacheDB.containsKey(key);
    }

    @Override
    public void delete(Long key) {
        cacheDB.remove(key);
    }

    @Override
    public void setTTL(Long key) {

    }
}
