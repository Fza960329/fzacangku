package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BankService;


@Controller
public class MainController {
	@Autowired
	private BankService bankService;

	
	
   /* @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }*/
	
	/*@GetMapping("/login")
	public String login() {
		return "user";
	}*/
	
	@ResponseBody
	@GetMapping("/user")
	public String user(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		String username = ((UserDetails)principal).getUsername();
		} else {
		String username = principal.toString();
		}
		return "aaa";
	}
}