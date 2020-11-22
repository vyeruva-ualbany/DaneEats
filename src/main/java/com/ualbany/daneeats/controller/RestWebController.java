package com.ualbany.daneeats.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ualbany.daneeats.model.MenuItem;
import com.ualbany.daneeats.model.Order;
import com.ualbany.daneeats.model.OrderItem;
import com.ualbany.daneeats.model.OrderStatus;
import com.ualbany.daneeats.model.Persistable;
import com.ualbany.daneeats.model.Response;
import com.ualbany.daneeats.model.User;
import com.ualbany.daneeats.repository.MenuItemRepository;
import com.ualbany.daneeats.repository.UserRepository;
import com.ualbany.daneeats.service.OrderService;
import com.ualbany.daneeats.service.UserServiceImpl;
import com.ualbany.daneeats.service.UserService;
import com.ualbany.daneeats.validator.UserValidator;

@RestController
@RequestMapping("/api")
public class RestWebController {

	@Autowired
	OrderService orderservice;
	
	@Autowired
	UserService userservice;

	@Autowired
	UserRepository userrepo;

	@Autowired
	MenuItemRepository menurepo;
	
	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserService userService;
	
	  @Value("${STRIPE_PUBLIC_KEY}")
	    private String stripePublicKey;

	    @RequestMapping("/checkout")
	    public String checkout(Model model) {
	        model.addAttribute("amount", 50 * 100); // in cents
	        model.addAttribute("stripePublicKey", stripePublicKey);
	        model.addAttribute("currency", ChargeRequest.Currency.EUR);
	        return "checkout";
	    }
	
	@PostMapping(value = "/order/save")
	public Response saveOrder(@RequestBody String order) {
		// cust.add(customer);
		JSONObject jsonOrder = new JSONObject(order.toString());

		Order ord = new Order();
		//User user = userrepo.findById(jsonOrder.getLong("customerId")).get();
		User user = userService.findByUsername(userValidator.username);
		ord.setCustomer(user);
		ord.setStatus(OrderStatus.NEW);
		JSONArray jsonitems = jsonOrder.getJSONArray("items");
		List<OrderItem> items = new ArrayList<OrderItem>();
		for (int i = 0; i < jsonitems.length(); i++) {
			JSONObject jsonitem = jsonitems.getJSONObject(i);
			OrderItem item = new OrderItem();
			MenuItem menuItem = menurepo.findById(jsonitem.getLong("menuId")).get();
			item.setMenuItem(menuItem);
			item.setQuantity(jsonitem.getInt("quantity"));
			item.setOrder(ord);
			setpersistableproperties(item, user);
			items.add(item);
		}
		ord.setItems(items);
		ord.setSource(items.get(0).getMenuItem().getRestaurant().getName());
		ord.setDestination(jsonOrder.getString("destination"));
		ord.setAmount(jsonOrder.getDouble("amount"));
		ord.setPhoneNumber(jsonOrder.getString("phonenumber"));
		setpersistableproperties(ord, user);
		orderservice.save(ord);
		// Create Response Object
		Response response = new Response("Done", jsonOrder);
		return response;
	}

	@PostMapping("/delivery/acceptorder")
	public Response acceptOrder(@RequestBody String order) {
		JSONObject jsonOrder = new JSONObject(order.toString());
		Long id = jsonOrder.getLong("id");
		Order ord = orderservice.findById(id);
		Long agentId = jsonOrder.getLong("agentId");
		User aget = userrepo.findById(agentId).get();
		ord.setAgent(aget);
		ord.setUpdatedAt(new Date());
		ord.setUpdatedBy(aget);
		ord.setStatus(OrderStatus.ACCEPTED_BY_AGENT);
		orderservice.save(ord);
		Response response = new Response("Done", id);
		return response;
	}
	
	@PostMapping("/delivery/declineorder")
	public Response declineOrder(@RequestBody String order) {
		JSONObject jsonOrder = new JSONObject(order.toString());
		Long id = jsonOrder.getLong("id");
		Order ord = orderservice.findById(id);
		Long agentId = jsonOrder.getLong("agentId");
		User aget = userrepo.findById(agentId).get();
		ord.setAgent(aget);
		ord.setUpdatedAt(new Date());
		ord.setUpdatedBy(aget);
		ord.setStatus(OrderStatus.NEW);
		orderservice.save(ord);
		Response response = new Response("Done", id);
		return response;
	}

	@PostMapping("/delivery/claimorder")
	public Response claimOrder(@RequestBody String order) {
		JSONObject jsonOrder = new JSONObject(order.toString());
		Long id = jsonOrder.getLong("id");
		Order ord = orderservice.findById(id);
		Long agentId = jsonOrder.getLong("agentId");
		User aget = userrepo.findById(agentId).get();
		ord.setAgent(aget);
		ord.setUpdatedAt(new Date());
		ord.setUpdatedBy(aget);
		ord.setStatus(OrderStatus.CLAIMED_BY_AGENT);
		orderservice.save(ord);
		Response response = new Response("Done", id);
		return response;
	}
	
	@PostMapping("/delivery/pickuporder")
	public Response pickupOrder(@RequestBody String order) {
		JSONObject jsonOrder = new JSONObject(order.toString());
		Long id = jsonOrder.getLong("id");
		Order ord = orderservice.findById(id);
		Long agentId = jsonOrder.getLong("agentId");
		User aget = userrepo.findById(agentId).get();
		ord.setAgent(aget);
		ord.setUpdatedAt(new Date());
		ord.setUpdatedBy(aget);
		ord.setStatus(OrderStatus.PICKED_UP);
		orderservice.save(ord);
		Response response = new Response("Done", id);
		return response;
	}
	
	@PostMapping("/delivery/deliverorder")
	public Response deliverOrder(@RequestBody String order) {
		JSONObject jsonOrder = new JSONObject(order.toString());
		Long id = jsonOrder.getLong("id");
		Order ord = orderservice.findById(id);
		Long agentId = jsonOrder.getLong("agentId");
		User aget = userrepo.findById(agentId).get();
		ord.setAgent(aget);
		ord.setUpdatedAt(new Date());
		ord.setUpdatedBy(aget);
		ord.setStatus(OrderStatus.DELIVERED_BY_AGENT);
		orderservice.save(ord);
		Response response = new Response("Done", id);
		return response;
	}
	@PostMapping("/delivery/cancelorder")
	public Response cancelOrder(@RequestBody String order) {
		JSONObject jsonOrder = new JSONObject(order.toString());
		Long id = jsonOrder.getLong("id");
		Order ord = orderservice.findById(id);
		Long agentId = jsonOrder.getLong("agentId");
		User aget = userrepo.findById(agentId).get();
		ord.setAgent(aget);
		ord.setUpdatedAt(new Date());
		ord.setUpdatedBy(aget);
		ord.setStatus(OrderStatus.CANCELLED);
		orderservice.save(ord);
		Response response = new Response("Done", id);
		return response;
	}
	@PostMapping("/user/updatepass")
	public Response updatePass(@RequestBody String user) {
		JSONObject jsonUser = new JSONObject(user.toString());
		String username = jsonUser.getString("username");
		String password = jsonUser.getString("password");
		String passwordConfirm = jsonUser.getString("confirm_pass");
		User user1 = userservice.findByUsername(username);
		user1.setPassword(password);
		user1.setPasswordConfirm(passwordConfirm);
		userservice.save(user1);
		Response response = new Response("Done", username);
		return response;
	}
	@PostMapping("/user/updateusername")
	public Response updateUsername(@RequestBody String user) {
		JSONObject jsonUser = new JSONObject(user.toString());
		String username = jsonUser.getString("username");
		String new_username = jsonUser.getString("new_username");
		User user1 = userservice.findByUsername(username);
		user1.setUsername(new_username);
		userservice.save(user1);
		Response response = new Response("Done", new_username);
		return response;
	}

	void setpersistableproperties(Persistable ps, User user) {
		Date now = new Date();
		ps.setCreatedAt(now);
		ps.setUpdatedAt(now);
		ps.setCreatedBy(user);
		ps.setUpdatedBy(user);
	}
}