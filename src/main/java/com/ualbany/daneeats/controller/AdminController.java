package com.ualbany.daneeats.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ualbany.daneeats.model.Restaurant;
import com.ualbany.daneeats.model.Role;
import com.ualbany.daneeats.model.User;
import com.ualbany.daneeats.model.UserRoleType;
import com.ualbany.daneeats.service.OrderService;
import com.ualbany.daneeats.service.UserService;
import com.ualbany.daneeats.validator.UserValidator;

@Controller
public class AdminController {

	@Autowired
    private UserService userService;
    
    @Autowired
	OrderService  orderservice;
    
    @Autowired
    private UserValidator userValidator;
    
    @GetMapping("/registerbyadmin")
    public String registration1(Model model) {
        model.addAttribute("userForm", new User());
        return "adminUser";
    }
    
    @PostMapping("/addcutomer")
    public String addcutomer(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "adminUser";
        }
        Date now = new Date();
        Role role = new Role();
        role.setCreatedAt(now);
        role.setUpdatedAt(now);
        role.setRoleType(UserRoleType.CUSTOMER);
        
        userForm.addRole(role);
        userForm.setCreatedAt(now);
        userForm.setUpdatedAt(now);
        userService.save(userForm);

       return "adminHome";
    }
    
    @PostMapping("/adddeliveryagent")
    public String adddeliveryagent(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "adminUser";
        }
        Date now = new Date();
        Role role = new Role();
        role.setCreatedAt(now);
        role.setUpdatedAt(now);
        role.setRoleType(UserRoleType.CUSTOMER);
        
        userForm.addRole(role);
        userForm.setCreatedAt(now);
        userForm.setUpdatedAt(now);
        userService.save(userForm);
       return "adminHome";
    }
}
