package com.ualbany.daneeats.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ualbany.daneeats.model.User;
import com.ualbany.daneeats.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    public String username;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (!userService.findByEmail(user.getEmail()).isEmpty()) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
      
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void validateLogin(Object o, Errors errors) {
		User user = (User) o;
		username = user.getUsername();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

		if (userService.findByUsername(user.getUsername()) != null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
			String upass = user.getPassword();
			System.out.println("password from front end" + upass);
			String p = userService.findByUsername(user.getUsername()).getPassword();
			// username=userService.findByUsername(user.getUsername()).getUsername();

			System.out.println("encoded pass" + p);
			if (!bCryptPasswordEncoder.matches(upass, p)) {
				System.out.print("hey");
				errors.rejectValue("password", "Invalid.Password");
			}
		} else {
			System.out.println("user from database end=" + userService.findByUsername(user.getUsername()));
			System.out.println("not it's not exists");
			errors.rejectValue("username", "Invaid.username");
		}
	}
}
