package com.example.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//@Component(value="helloService")
@Named("helloService")
//@Service
public class HelloWorldService {

	@Value("${name:World}")
	private String name;

	public String getHelloMessage() {
		return "Hello " + this.name;
	}
	
	public void sayHello() {
		System.out.println("Hello " + this.name);
	}
	
}
