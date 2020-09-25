package com.ualbany.daneeats.controller;

import com.ualbany.daneeats.model.MenuItem;
import com.ualbany.daneeats.repository.MenuItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/menuitem")
public class MenuItemController {

    @Autowired 
    private MenuItemRepository menuItemRepository;

    @PostMapping(path="/add") 
     public @ResponseBody String addNewItem (@RequestParam String name
      , @RequestParam Double price, @RequestParam Integer calories, @RequestParam String description) {

    MenuItem item = new MenuItem();  
    item.setName(name);
    item.setPrice(price);
    item.setCalories(calories);
    item.setDescription(description);
    menuItemRepository.save(item);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<MenuItem> getAllItems() {
    return menuItemRepository.findAll();
  }

  @GetMapping(path="/name")
  public @ResponseBody MenuItem getByName(@RequestParam String name) {
    return menuItemRepository.findByName(name);
  }
}
