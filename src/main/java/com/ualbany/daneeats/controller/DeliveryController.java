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
import com.ualbany.daneeats.service.OrderService;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	OrderService  orderservice;
	
	
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
    
    @GetMapping("/availableorders")
    public ModelAndView availableOrders() {
       System.out.print("hello");
       ModelAndView modelandview1 =new ModelAndView("ViewOrders");
       List<Order> aorders=orderservice.findByStatus(OrderStatus.NEW);
       modelandview1.addObject("Aorders",aorders);
		return modelandview1;
    } 
    
    @GetMapping("/currentorders")
    public ModelAndView currentOrders(Long agentId) {
       System.out.print("hello");
       agentId = 1L;
       ModelAndView modelandview2 =new ModelAndView("CurrentOrders");
       List<Order> corders=orderservice.findAgentOrdersWithStatus(agentId, OrderStatus.ACCEPTED_BY_AGENT, 
    		   OrderStatus.CLAIMED_BY_AGENT, OrderStatus.PICKED_UP);
       modelandview2.addObject("Corders",corders);
		return modelandview2;
    } 
    
    @GetMapping("/previousordersd")
    public ModelAndView previousOrdersD(Long agentId) {
       System.out.print("hello");
       agentId = 1L;
       ModelAndView modelandview3 =new ModelAndView("PreviousOrdersD");
       List<Order> pordersD=orderservice.findAgentOrdersWithStatus(agentId, OrderStatus.DELIVERED_BY_AGENT, 
    		   OrderStatus.DELIVERY_COMPLETED);
       modelandview3.addObject("Porders",pordersD);
		return modelandview3;
    }
}
