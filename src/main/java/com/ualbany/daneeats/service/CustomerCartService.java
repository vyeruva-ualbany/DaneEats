package com.ualbany.daneeats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.daneeats.model.CustomerCartItem;
import com.ualbany.daneeats.repository.CustomerCartRepository;

@Service
public class CustomerCartService {
	
    @Autowired
    private CustomerCartRepository repository;

    public void save(CustomerCartItem item) {
    	repository.save(item);
    }

    public List<CustomerCartItem> findByUserId(Integer id) {
    	return repository.findByCustomerId(id);
    }
     
    public CustomerCartItem findById(Integer id) {
    	Optional<CustomerCartItem> item= repository.findById(id);
    	if(item.isPresent())
    		return item.get();
    	else
    		return null;
    }
}
