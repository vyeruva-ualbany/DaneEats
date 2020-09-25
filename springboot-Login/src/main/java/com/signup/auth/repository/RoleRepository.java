package com.signup.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signup.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
