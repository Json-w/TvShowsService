package com.jason.service;

import com.jason.model.User;

public interface UserService {
    boolean login(User user);

    boolean save(User user);

    User find(String username);

    User find(int id);
}
