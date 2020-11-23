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
@RequestMapping("/customer")
public class CustomerController {

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
        ModelAndView mv = new ModelAndView("changePassC");
        return mv;
    }
    
    @GetMapping("/updateusername")//for both /,welcome this will be called
    public ModelAndView updateUsername(Model model) {
        ModelAndView mv = new ModelAndView("updateUsernameC");
        return mv;
    }
    
    @GetMapping("/placeorder")//for both /,welcome this will be called
    public ModelAndView placeOrderGet(Model model) {
        ModelAndView mv = new ModelAndView("customer");
        return mv;
    }
     
    @GetMapping("/menu")//for both /,welcome this will be called
    public ModelAndView menuGet(Model model) {
    	ModelAndView mv = new ModelAndView("menu");
        return mv;
    }
    
    @GetMapping("/pastorders")
    public ModelAndView pastorders() {
       User user = userservice.findByUsername(userValidator.username);
       ModelAndView modelandview =new ModelAndView("pastorders");
       List<Order> orders=orderservice.findAllbyCustomerOrdersWithStatus(user.getId(), OrderStatus.ACCEPTED_BY_AGENT, 
    		   OrderStatus.CANCELLED, OrderStatus.CLAIMED_BY_AGENT, OrderStatus.DELIVERED_BY_AGENT, OrderStatus.DELIVERY_COMPLETED,OrderStatus.PICKED_UP);
       modelandview.addObject("orders",orders);
		return modelandview;
    } 
    
    @GetMapping("/currentorders")
    public ModelAndView currentorders() {
       User user = userservice.findByUsername(userValidator.username);
       ModelAndView modelandview =new ModelAndView("orders");
       List<Order> orders=orderservice.findAllbyCustomerOrdersWithStatus(user.getId(), OrderStatus.NEW);
       for(int i=0;i<orders.size();i++)
       {
    	   System.out.println(orders.get(i).getStatus());
       }
       modelandview.addObject("orders",orders);
		return modelandview;
    }
}
