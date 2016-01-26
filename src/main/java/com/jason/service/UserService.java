package com.jason.service;

import com.jason.model.User;

public interface UserService {
    boolean login(String username, String password);

    boolean save(User user);

    User find(String username);
}
