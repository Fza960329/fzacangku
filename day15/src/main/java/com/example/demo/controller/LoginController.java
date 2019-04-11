package com.example.demo.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@GetMapping("/loginP")
	public String login() {
		return "loginPage";
	}
	@GetMapping("/index")
	@ResponseBody
	public String main(User user) {
		return user.getUsername()+"登录成功";
	}
}
