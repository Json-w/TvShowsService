package com.jason.service.impl;

import com.jason.model.User;
import com.jason.repository.UserRepository;
import com.jason.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean login(User user) {
        User loginedUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (null != loginedUser) {
            generateTokenAndSaveToCache(loginedUser);
            return true;
        }
        return false;
    }

    private void generateTokenAndSaveToCache(User loginedUser) {
        ValueOperations<String, String> opt = redisTemplate.opsForValue();
        String uuid = UUID.randomUUID().toString();
        opt.set(uuid, loginedUser.getId() + "");
        opt.set(loginedUser.getUsername(), uuid);
    }


    @Override
    public boolean save(User user) {
        if (null == userRepository.findByUsername(user.getUsername())) {
            return null != userRepository.save(user);
        }
        return false;
    }

    @Override
    public User find(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User find(int id) {
        return userRepository.findOne(id);
    }
}
