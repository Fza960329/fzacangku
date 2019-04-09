package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.controller.user;



@SpringBootApplication
public class JdbcConnectionApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void demo() {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from grade", Integer.class);
		System.out.println(rowCount);
		
		int countOfActorsNamedJoe = this.jdbcTemplate.queryForObject(
		        "select count(*) from grade where gteacher = ?", Integer.class, "大明");
		System.out.println(countOfActorsNamedJoe);
		
		String lastName = this.jdbcTemplate.queryForObject(
		        "select gclass from grade where gclass = ?",
		         String.class,1);
		System.out.println(lastName);
		
			
		user user = this.jdbcTemplate.queryForObject(
		        "select gclass from grade where gclass= ?",
//		        new Object[]{1212L},
		        new RowMapper<user>() {
		            public user mapRow(ResultSet rs, int rowNum) throws SQLException {
		                user user = new user();
		                user.setGclass("2");		               
		                return user;
		            }
		        },2);
		System.out.println(user);
		
		List<user> users = this.jdbcTemplate.query(
		        "select gteacher,gstudent from grade",
		        new RowMapper<user>() {
		            public user mapRow(ResultSet rs, int rowNum) throws SQLException {
		                user users = new user();
		                user.setGteacher("大红");
		                user.setGstudent("大黄");
		                return user;
		            }
		        });
		System.out.println(users);
		
		//添加数据
		/*this.jdbcTemplate.update(
		        "insert into grade (gclass,gteacher,gstudent) values (?,?,?)",
		        "6", "大猴","小猴");*/
		
		//修改数据
		/*this.jdbcTemplate.update(
		        "update grade set gstudent = ? where gclass = ?",
		        "辛侯", 6);*/
		
		
	}
	
	//提取出来的方法
	/*public List<user> findAllUsers() {
	    return this.jdbcTemplate.query( "select gteacher,gstudent from grade", new UserMapper());
	}

	private static final class UserMapper implements RowMapper<user> {

	    public user mapRow(ResultSet rs, int rowNum) throws SQLException {
	        user users= new user();
	        users.setGclass(rs.getString("gclass"));
	        users.setGteacher(rs.getString("gteacher"));
	        return users;
	    }
	}*/
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	public int countOfActorsByFirstName(String gClass) {
		String sql = "select count(*) from grade where gclass = :gclass";
		SqlParameterSource namedParameters = new MapSqlParameterSource("gclass", gClass);
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcConnectionApplication.class, args);
	}

}
