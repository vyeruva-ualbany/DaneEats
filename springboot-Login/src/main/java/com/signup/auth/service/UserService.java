package com.signup.auth.service;

import java.util.List;

import com.signup.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    List<User> findByEmail(String email);
}
