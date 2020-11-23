package com.ualbany.daneeats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.daneeats.model.Order;
import com.ualbany.daneeats.model.OrderStatus;
import com.ualbany.daneeats.model.User;
import com.ualbany.daneeats.service.OrderService;
import com.ualbany.daneeats.service.UserService;
import com.ualbany.daneeats.validator.UserValidator;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	OrderService  orderservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	private UserValidator userValidator;
	
    @PostMapping("/profile")//for both /,welcome this will be called
    public ModelAndView profilePost(Model model) {
    	 ModelAndView mv = new ModelAndView("customerprofile");
         return mv;
    }
    
    @GetMapping("/profile")//for both /,welcome this will be called
    public ModelAndView profileGet(Model model) {
        ModelAndView mv = new ModelAndView("customerprofile");
        return mv;
    }
    @GetMapping("/changepassword")//for both /,welcome this will be called
    public ModelAndView passChange(Model model) {
        ModelAndView mv = new ModelAndView("changePassD");
        return mv;
    }
    @GetMapping("/updateusername")//for both /,welcome this will be called
    public ModelAndView updateUsername(Model model) {
        ModelAndView mv = new ModelAndView("updateUsername");
        return mv;
    }
    
    @GetMapping("/allorders")
    public ModelAndView allorders(Long agentId) {
       ModelAndView modelandview1 =new ModelAndView("adminOrders");
       User user = userservice.findByUsername(userValidator.username);
       List<Order> aorders=orderservice.findByStatus(OrderStatus.NEW);
       modelandview1.addObject("Corders",aorders);
       List<Order> aorders1=orderservice.findAgentOrdersWithStatus(user.getId(),OrderStatus.ACCEPTED_BY_AGENT,OrderStatus.CLAIMED_BY_AGENT,OrderStatus.PICKED_UP);
       modelandview1.addObject("Corders",aorders1);
		return modelandview1;
    } 
    
    @GetMapping("/availableorders")
    public ModelAndView availableOrders() {
       ModelAndView modelandview1 =new ModelAndView("ViewOrders");
       List<Order> aorders=orderservice.findByStatus(OrderStatus.NEW);
       modelandview1.addObject("Aorders",aorders);
		return modelandview1;
    } 
    
    @GetMapping("/claimedorders")
    public ModelAndView claimedOrders(Long agentId) {
       User user = userservice.findByUsername(userValidator.username);
       ModelAndView modelandview2 =new ModelAndView("CurrentOrders");
       List<Order> corders=orderservice.findAgentOrdersWithStatus(user.getId(), OrderStatus.CLAIMED_BY_AGENT);
       modelandview2.addObject("Corders",corders);
		return modelandview2;
    } 
    @GetMapping("/currentorders")
    public ModelAndView currentOrders(Long agentId) {
       User user = userservice.findByUsername(userValidator.username);
       ModelAndView modelandview4 =new ModelAndView("ongoingOrders");
       List<Order> corders=orderservice.findAgentOrdersWithStatus(user.getId(), OrderStatus.ACCEPTED_BY_AGENT,OrderStatus.PICKED_UP);
       modelandview4.addObject("Oorders",corders);
		return modelandview4;
    } 
    
    @GetMapping("/previousordersd")
    public ModelAndView previousOrdersD() {
       User user = userservice.findByUsername(userValidator.username);
       ModelAndView modelandview3 =new ModelAndView("PreviousOrdersD");
       List<Order> pordersD=orderservice.findAgentOrdersWithStatus(user.getId(), OrderStatus.DELIVERED_BY_AGENT, 
    		   OrderStatus.DELIVERY_COMPLETED);
       modelandview3.addObject("Porders",pordersD);
		return modelandview3;
    }
}
