package cn.com.taiji.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.taiji.DateJpa12Application;
import cn.com.taiji.domain.User;
import cn.com.taiji.domain.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DateJpa12ApplicationTests {

	
/*	
	@Test
	public void contextLoads() {
	}*/
	public static final Logger log = LoggerFactory.getLogger(DateJpa12Application.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private UserService userService;
	
	
	@Test
	public void test1() {
		for (int i = 0; i < 9; i++) {
			User user = new User();
			user.setName("tom"+i);
			user.setPassword("a"+i);
			userService.saveUser(user);
			
		}
	}
	@Ignore
	@Test
	public void testPage() {
		String map = "{\"page\" : 1,\"pageSize\" : 5, \"filter\":{ \"filters\":[{ \"field\" : \"deptName\", \"value\":\"机构8\"}]}}";
		Map searchParameters = new HashMap();
		try {
			searchParameters = objectMapper.readValue(map, new TypeReference<Map>() {
			});
		} catch (JsonParseException e) {
			log.error("JsonParseException{}:", e.getMessage());
		} catch (JsonMappingException e) {
			log.error("JsonMappingException{}:", e.getMessage());
		} catch (IOException e) {
			log.error("IOException{}:", e.getMessage());
		}

		Map mapDept = userService.getPage(searchParameters);

		System.out.println(mapDept.get("total"));

		System.out.println(mapDept.get("depts"));
	}

}
