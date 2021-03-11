package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.service.CacheService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/get-user-data")
    @ResponseBody
    public String getUserData(@RequestParam("id") long id) throws InterruptedException {
        User user = new User(6);
        if (!cacheService.has(user.getUserId())) {
            cacheService.save(user.getUserId(), getDataSlow());
            return cacheService.get(id);
        }
        return cacheService.get(id);
    }

    private String getDataSlow() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return RandomStringUtils.randomAlphabetic(200);
    }

}
