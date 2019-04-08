package com.example.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
	@RequestMapping("/test")
	public String test(String id) {
	 System.out.println("前端id"+id);
	 return id;
	}

}
