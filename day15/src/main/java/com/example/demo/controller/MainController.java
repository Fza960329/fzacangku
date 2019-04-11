package com.example.demo.controller;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
 @GetMapping
 public String home() {
	 return "home";
 }
 protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()                                                                
				.antMatchers("/resources/**", "/signup", "/about").permitAll()                  
				.antMatchers("/admin/**").hasRole("ADMIN")                                      
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            
				.anyRequest().authenticated()                                                   
				.and()
			// ...
			.formLogin();
	}
	 
 }

