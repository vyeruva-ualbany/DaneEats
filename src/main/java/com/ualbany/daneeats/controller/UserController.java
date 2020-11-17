package com.ualbany.daneeats.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ualbany.daneeats.model.Role;
import com.ualbany.daneeats.model.User;
import com.ualbany.daneeats.model.UserRoleType;
import com.ualbany.daneeats.service.OrderService;
import com.ualbany.daneeats.service.UserService;
import com.ualbany.daneeats.service.VerificationTokenService;
import com.ualbany.daneeats.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
	OrderService  orderservice;
    
    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
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

       model.addAttribute("verificationForm", userForm);

        verificationTokenService.createVerification(userForm.getEmail());
        return "verification-form";
    }

    @GetMapping("/verify-email")
    @ResponseBody
    public String verifyEmail(String code) {
        return verificationTokenService.verifyEmail(code).getBody();
    }
    
    @GetMapping("/home")
    public String home() {
    	
        return "home";
    }
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
    	model.addAttribute("userForm", new User());
        return "login";
    }
    
    @GetMapping("/profile")
    public String profile() {
    	
        return "DeliveryProfile";
    }
    
    
    @PostMapping("/Customer-login")//for both /,welcome this will be called
    public String checkloginforCustomer(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

		userValidator.validateLogin(userForm, bindingResult);
		// securityService.autoLogin(userForm.getUsername(),
		// userForm.getPasswordConfirm());
		// uname=userForm.getUsername();
		if (bindingResult.hasErrors()) {
			return "login";
		} else {
			return "customer";
		}
	}
    
   
    @PostMapping("/Delivery-login")//for both /,welcome this will be called
    public String checkloginfordeliveryguy(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

		userValidator.validateLogin(userForm, bindingResult);
		// securityService.autoLogin(userForm.getUsername(),
		// userForm.getPasswordConfirm());
		// uname=userForm.getUsername();
		if (bindingResult.hasErrors()) {
			return "login";
		} else {
			return "DeliveryProfile";
		}
	}
}
