package com.ualbany.daneeats.service;

import java.util.List;

import com.ualbany.daneeats.model.MenuItem;

public interface MenuItemService {
    void save(MenuItem item);

    MenuItem findByName(String name);
    List<MenuItem> findAll();
}
