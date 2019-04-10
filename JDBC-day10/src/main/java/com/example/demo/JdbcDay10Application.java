package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcDay10Application implements CommandLineRunner {

	
/*	public void JDBC() {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from emp",Integer.class);
		System.out.println(rowCount);
	}*/
 
	public static void main(String[] args) {
		SpringApplication.run(JdbcDay10Application.class, args);
		
	
	}

	@Override
	public void run(String... args) throws Exception {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from emp",Integer.class);
		System.out.println(rowCount);
	}

}
