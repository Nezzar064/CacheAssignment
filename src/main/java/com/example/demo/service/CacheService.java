package com.example.demo.service;

public interface CacheService {

    String get(Long key);

    void save(Long key, String value);

    boolean has(Long key);

    void delete(Long key);

    void setTTL(Long key);
}
