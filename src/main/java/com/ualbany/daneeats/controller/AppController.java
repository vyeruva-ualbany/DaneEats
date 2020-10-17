package com.ualbany.daneeats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class AppController {
	
    @GetMapping(value="/")
    public String homepage(){
        return "welcome";
    }
    
    @GetMapping(value="/menu")
    public String menu(){
        return "menu";
    }
    
    @GetMapping(value="/login")
    public String login(){
        return "login";
    }
    
	@GetMapping(path="/customer") 
	public String getCustomer () {
		return "customer";
	}
}