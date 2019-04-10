package com.example.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.*;
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		//manager.createUser(User.withUsername("user").password("password").roles("USER").build());
		manager.createUser(User.withUsername("4").password("4").roles("ADMIN","DBA").build());
		manager.createUser(User.withUsername("3").password("3").roles("ADMIN","DBA").build());
		manager.createUser(User.withUsername("2").password("2").roles("ADMIN","DBA").build());
		manager.createUser(User.withUsername("1").password("1").roles("ADMIN","DBA").build());
		return manager;
	}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.anyRequest().authenticated()
					.and()
					.formLogin()
					.loginPage("/loginP") 
					.successForwardUrl("/index")
					.permitAll();        
			
		}
	}

