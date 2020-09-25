package com.signup.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signup.auth.model.VerificationToken;

import java.util.List;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
    List<VerificationToken> findByUserEmail(String email);
    List<VerificationToken> findByToken(String token);
}
