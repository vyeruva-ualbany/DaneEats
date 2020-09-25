package com.signup.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signup.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
   // User findByEmail(String email);
    List<User> findByEmail(String email);
}
