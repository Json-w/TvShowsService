package com.jason.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.model.User;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {
        JSONObject result = new JSONObject();
        if (!userService.login(user.getUsername(), user.getPassword())) {
            result.put("statusCode", 0);
            result.put("message", "failure");
            return result.toString();
        }
        result.put("token", redisTemplate.opsForValue().get(user.getUsername()));
        result.put("statusCode", 1);
        result.put("message", "success");
        result.put("user", userService.find(user.getUsername()));
        return result.toString();
    }
}
