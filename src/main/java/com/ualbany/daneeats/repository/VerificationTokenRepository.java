package com.ualbany.daneeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.ualbany.daneeats.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
    List<VerificationToken> findByUserEmail(String email);
    List<VerificationToken> findByToken(String token);
}
