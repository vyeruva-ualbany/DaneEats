package com.ualbany.daneeats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    //We need to make sure that no authentication is required for /register and /confirm URLs as they are the landing pages
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/resources/**", "/register","/verify-email","/Customer-login","/Delivery-login","/customer.png","/delivery.jpeg","/image2.jpg","/intro.jsp","/starbucks.jpg","/cart.html","/mcd.png","/pizza.png","/bk.png","/dunkin.png","/order.jsp","/CustomerProfile.jsp","/home.html","/dane.jpg","/ViewOrders.jsp","/DeliveryProfile.jsp","/home.jsp","/changePassC.jsp","/changePassD.jsp","/Action.jsp").permitAll()
                .anyRequest().authenticated()
                .and()
                
            .formLogin()
               .loginPage("/home")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}