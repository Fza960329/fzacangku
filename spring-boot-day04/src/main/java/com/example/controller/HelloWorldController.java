package com.example.controller;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
@SpringBootApplication
public class HelloWorldController {
	@Value("${name}")
	private String name;
	@Value("${my.age}")
	private int age;

	@RequestMapping("/hello")
	public String index() {
		logger.debug("Sample Debug Message");
		logger.info("Sample Info Message");
		logger.trace("Sample trace Message");
		logger.error("Sample error Message");
		logger.warn("Sample warn Message");
		return "Hello World" + age;

	}
	
	private static final Logger logger =(Logger) LoggerFactory.getLogger(HelloWorldController.class);
	
@PostConstruct
	public void logSomething() {
	
	}
}
