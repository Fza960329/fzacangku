package com.example;

import java.util.stream.Collectors;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import de.codecentric.boot.admin.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer

public class SpringBootDay04Application {
  //默认生成的   spring-boot启动类
	public static void main(String[] args) {
		System.out.println("begin===");
		SpringApplication.run(SpringBootDay04Application.class, args);
		System.out.println("stop===");
	}
		
		@Bean
		public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
			return args -> {
				System.out.println("list beans:"+ctx.getBeanDefinitionCount());
				
			};
			}

		@Bean
		public ApplicationRunner appRunner() {
			return args -> {
				System.out.println();
				System.out.println("Application Runner:");
				for (String opt : args.getOptionNames()) {
					System.out.print(opt);
					System.out.print("->");
					System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining(",", "[", "]")));
					// String.join(",", args.getOptionValues(opt));
				}
			};
		}
		
		

		@Bean
		public ApplicationListener<ApplicationEvent> helloListener() {
			final String HELLO_URL = "/hello";
			return (ApplicationEvent event) -> {
				if (event instanceof ServletRequestHandledEvent) {
					ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
					if (e.getRequestUrl().equals(HELLO_URL))
						System.out.println("visit hello");
				}
			};
		}
		
}
