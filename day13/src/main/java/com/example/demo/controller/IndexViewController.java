package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexViewController {
	/**
	 * 登录
	 * @return
	 */
	@GetMapping("/")
	public String index() {
		return "login";
	}
	
	/**
	 * 欢迎页
	 * @return
	 */
	@GetMapping("/welcome")
    public String welcome() {
    	return "welcome";
    }
	
}
