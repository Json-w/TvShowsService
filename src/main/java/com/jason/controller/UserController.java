package com.jason.controller;

import com.jason.mail.MailSenderFactory;
import com.jason.mail.SimpleMailSender;
import com.jason.model.ResponseData;
import com.jason.model.Status;
import com.jason.model.User;
import com.jason.service.FollowerService;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private FollowerService followerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(User user) {
        ResponseData response = new ResponseData();
        if (!userService.login(user)) {
            response.setStatus(Status.FAILURE);
            return response;
        }
        response.setStatus(Status.SUCCESS);

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("token", redisTemplate.opsForValue().get(user.getUsername()));
        data.put("user", userService.find(user.getUsername()));
        response.setData(data);

        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseData register(User user) {
        ResponseData response = new ResponseData();
        if (userService.save(user)) {
            response.setStatus(Status.SUCCESS);
        } else {
            response.setStatus(Status.FAILURE);
        }
        return response;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseData getInfo(@PathVariable int userId) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(Status.SUCCESS);
        User user = userService.find(userId);
        user.setFollowersNum(followerService.countFollowersNum(userId));
        user.setFollowingNum(followerService.countFollowingNum(userId));
        user.setPassword("");
        responseData.setData(user);
        return responseData;
    }

    @RequestMapping(value = "/checkUsernameIfRepeat/{username}", method = RequestMethod.GET)
    public ResponseData checkUsernameIfRepeat(@PathVariable String username) {
        ResponseData responseData = new ResponseData();
        if (null == userService.find(username)) {
            responseData.setStatus(Status.SUCCESS);
        } else {
            responseData.setStatus(Status.FAILURE);
        }
        return responseData;
    }

    @RequestMapping(value = "/findPassword/{userId}", method = RequestMethod.GET)
    public ResponseData findPassword(@PathVariable int userId, HttpServletRequest request) throws MessagingException {
        ResponseData responseData = new ResponseData();
        Map<String, String> data = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        redisTemplate.opsForValue().set(userId + "", uuid);
        SimpleMailSender simpleMailSender = MailSenderFactory.getSimpleMailSender();
        User user = userService.find(userId);
        simpleMailSender.send(user.getEmail(), "密码找回", "请访问链接:" + "localhost:8081/findPassword.html?userId=" + user.getId() + "&uuid=" + uuid);
        return responseData;
    }

    @RequestMapping(value = "/changePwd", method = RequestMethod.POST)
    public ResponseData changePwd(int userId, String uuid, String password, HttpServletRequest request) {
        ResponseData responseData = new ResponseData();
        if (redisTemplate.opsForValue().get(userId + "").equals(uuid)) {
            responseData.setStatus(Status.SUCCESS);
            User user = userService.find(userId);
            if (user != null) {
                user.setPassword(password);
                userService.update(user);
            }
        } else {
            responseData.setStatus(Status.FAILURE);
        }
        return responseData;
    }
}

