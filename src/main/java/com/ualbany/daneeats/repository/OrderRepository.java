package com.ualbany.daneeats.repository;

import com.ualbany.daneeats.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
