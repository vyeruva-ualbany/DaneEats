package com.ualbany.daneeats.service;

import java.util.List;

import com.ualbany.daneeats.model.MenuItem;
import com.ualbany.daneeats.repository.MenuItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository itemRepository;

    @Override
    public void save(MenuItem item) {
        itemRepository.save(item);
    }

    @Override
    public MenuItem findByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public List<MenuItem> findAll() {
        return itemRepository.findAll();
    }
    
}
