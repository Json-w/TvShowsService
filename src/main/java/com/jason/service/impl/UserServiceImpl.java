package com.jason.service.impl;

import com.jason.model.User;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(String username, String password) {
        return null != userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean save(User user) {
        return null != userRepository.save(user);
    }
}
