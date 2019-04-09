package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Day10Application {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void JDBC() {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from emp", Integer.class);
		System.out.println(rowCount);
		
		int countOfActorsNamedJoe = this.jdbcTemplate.queryForObject("select count(*) from emp where ename = ?", Integer.class, "123");
		System.out.println(countOfActorsNamedJoe);	
		
		String lastName = this.jdbcTemplate.queryForObject( "select age from emp where ename = ?",new Object[]{"123"}, String.class);
		System.out.println(lastName);
	}
}
	