package com.ualbany.daneeats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.ualbany.daneeats.service.VerificationTokenService;
import com.ualbany.daneeats.model.User;
import com.ualbany.daneeats.service.UserService;
import com.ualbany.daneeats.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

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
    
    @GetMapping("/customer-login")
    public String customerlogin(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "Customerlogin";
    }
    @GetMapping("/delivery-login")
    public String deliverylogin(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "Customerlogin";
    }

    @GetMapping({"/", "/welcome"})//for both /,welcome this will be called
    public String welcome(Model model) {
        return "welcome";
    }
}
