package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.service.HelloWorldService;
import com.example.bean.ExampleBean;
@Configuration
public class SampleConfig {
	@Bean
	public HelloWorldService HelloWorldService() {
		return new HelloWorldService();
	}
	@Bean
	public ExampleBean exampleBean() {
		ExampleBean exampleBean = new ExampleBean();
		return exampleBean;
		
	}
	
	 
	

}
