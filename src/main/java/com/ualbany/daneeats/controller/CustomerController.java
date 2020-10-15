package com.ualbany.daneeats.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ualbany.daneeats.model.CustomerCartItem;
import com.ualbany.daneeats.model.MenuItem;
import com.ualbany.daneeats.model.Order;
import com.ualbany.daneeats.model.Response;
import com.ualbany.daneeats.model.Restaurant;
import com.ualbany.daneeats.service.CustomerCartService;
import com.ualbany.daneeats.service.MenuItemService;
import com.ualbany.daneeats.service.OrderService;
import com.ualbany.daneeats.service.RestaurantService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerCartService  cartservice;
	
	@Autowired
	MenuItemService menuservice;
	
	@Autowired
	RestaurantService restaurantservice;
	
	@Autowired
	OrderService orderservice;
	
	@PostMapping(path="/add") 
	public @ResponseBody String addNewCartItem (@RequestParam Integer customer_Id
	 , @RequestParam Integer menu_Id) {
		 
		MenuItem menuitem = menuservice.findById(menu_Id);
		Restaurant restaurant = restaurantservice.findById(menuitem.getRestaurantId());
		CustomerCartItem cartitem = new CustomerCartItem();  
		cartitem.setCustomerId(customer_Id);
		cartitem.setCount(1);
		cartitem.setPrice(menuitem.getPrice());
		cartitem.setSource(restaurant.getAddress1());
		cartservice.save(cartitem);
		return "Saved";
	}
	
	@GetMapping(path="/allrestaurants") 
	public @ResponseBody List<Restaurant> getAllRestaurants () {
		List<Restaurant> restaurants = restaurantservice.findAll();
		return restaurants;
	}
	
	@GetMapping(path="/{id}/menu") 
	public @ResponseBody List<MenuItem> getAllMenuItems (@RequestParam Integer restaurant_Id) {
		return restaurantservice.findAllMenuItems(restaurant_Id);
	}
	
	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody String items) {
		//cust.add(customer);
		JSONArray array = new JSONArray(items);  
		for(int i=0; i < array.length(); i++)   
		{  
			JSONObject object = array.getJSONObject(i);  
			Order ord = new Order();
			ord.setCustomerId(1);
			ord.setMenuId(object.getInt("id"));
			ord.setAmount(object.getDouble("price"));
			ord.setQuantity(object.getDouble("quantity"));
			ord.setStatus(0);
			ord.setSource(object.getString("source"));
			ord.setDestination(object.getString("destination"));
			orderservice.save(ord);
		}  
		// Create Response Object
		Response response = new Response("Done", items);
		return response;
	}
}
