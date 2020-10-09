package com.ualbany.daneeats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.daneeats.model.CustomerCartItem;

public interface CustomerCartRepository extends JpaRepository<CustomerCartItem, Integer> {
    List<CustomerCartItem> findByCustomerId(Integer id);
}
