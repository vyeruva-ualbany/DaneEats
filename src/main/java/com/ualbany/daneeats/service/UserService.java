package com.ualbany.daneeats.service;

import java.util.List;

import com.ualbany.daneeats.model.User;

public interface UserService {
    void save(User user);

    User findByUserName(String username);
    List<User> findByEmail(String email);
}
