package com.ualbany.daneeats.controller;

import com.ualbany.daneeats.model.MenuItem;
import com.ualbany.daneeats.model.Restaurant;
import com.ualbany.daneeats.model.User;
import com.ualbany.daneeats.service.MenuItemService;
import com.ualbany.daneeats.service.RestaurantService;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/menuitem")
public class MenuItemController {

    @Autowired 
    private MenuItemService service;
    
    @Autowired 
    private RestaurantService restaurant_service;


    @GetMapping("/add")
    public String updatemenu(Model model) {
        model.addAttribute("userForm", new MenuItem());
        List<Restaurant> list = restaurant_service.findAll();
        ModelAndView mv = new ModelAndView("addmenu");
        mv.addObject("restaurants", list);
        return "addmenu";
    }
    
    @PostMapping(path="/add") 
    public @ResponseBody String addNewItem (@ModelAttribute("menuItemForm") MenuItem menuitem, BindingResult bindingResult,Model model) {
    	Date now = new Date();
    	menuitem.setCreatedAt(now);
    	menuitem.setUpdatedAt(now);
    	service.save(menuitem);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody String getAllItems() {

		List<MenuItem> menuItems = service.findAll();
		JSONArray jsonArray = new JSONArray();

		for (MenuItem item : menuItems)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", item.getId());
			jsonObject.put("name", item.getName());
			jsonObject.put("price", item.getPrice());
			jsonObject.put("restaurant", item.getRestaurant().getId());
			jsonArray.put(jsonObject);
		}
		return jsonArray.toString();
  }

  @GetMapping(path="/name")
  public @ResponseBody String getByName(@RequestParam String name) {
	  MenuItem item = service.findByName(name);
	  JSONObject jsonObject = new JSONObject();
	  jsonObject.put("id", item.getId());
	  jsonObject.put("name", item.getName());
	  jsonObject.put("price", item.getPrice());
	  jsonObject.put("restaurant", item.getRestaurant().getId());
    return jsonObject.toString();
  }
}
