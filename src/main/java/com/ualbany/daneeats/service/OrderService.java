package com.ualbany.daneeats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.daneeats.model.Order;
import com.ualbany.daneeats.model.OrderStatus;
import com.ualbany.daneeats.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public void save(Order o) {
    	repository.save(o);
    }

    public Order findById(Long id) {
    	Optional<Order> Order= repository.findById(id);
    	if(Order.isPresent())
    		return Order.get();
    	else
    		return null;
    }

    public List<Order> findByStatus(OrderStatus status) {
    	List<Order> order= repository.findByStatus(status);
    	return order;
    }
    public List<Order> findAll() {
    	List<Order> orders = repository.findAll();
        return orders;
    }
    
    public List<Order> findCustomerOrders(Long id) {
    	List<Order> orders = repository.findByCustomerId(id);
        return orders;
    }
    
    public List<Order> findCustomerOrdersWithStatus(Long id, OrderStatus status) {
    	List<Order> orders = repository.findByCustomerIdAndStatus(id, status);
        return orders;
    }

    public List<Order> findByAgentId(Long id) {
    	List<Order> orders = repository.findByAgentId(id);
        return orders;
    }
        
    public List<Order> findAgentOrdersWithStatus(Long id, OrderStatus... status) {
    	List<Order> orders = repository.findAllByAgentIdAndStatus(id, status);
        return orders;
    }
    
    public void updateOrderStatus(Long id, OrderStatus status) {
    	repository.updateOrderStatus(id, status);
    }
}
