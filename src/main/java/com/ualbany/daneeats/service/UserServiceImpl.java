package com.ualbany.daneeats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.daneeats.model.User;
import com.ualbany.daneeats.repository.RoleRepository;
import com.ualbany.daneeats.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
   
}
