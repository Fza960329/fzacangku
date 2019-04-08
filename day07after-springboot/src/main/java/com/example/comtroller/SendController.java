package com.example.comtroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
//	1
	@RequestMapping("/one")
	public Integer oneParam(Integer id) {
		return id;
		
	}
	
	@RequestMapping("/two")
	public String Twoparam(String name,Integer id) {
		return name+""+id;
		
	}
	@RequestMapping("/path/{id}")
	public Integer pathParam(@PathVariable Integer id) {
		return id;
	}
    @RequestMapping("/user")
    public User getUser(User user) {
    	return user;
    }
    @RequestMapping("/map")
    public Map<String,Object> getMap(@RequestParam Map<String,Object> map){
    	  return map;
    }
    @RequestMapping("/requ")
    public String getRequ(HttpServletRequest request,HttpServletResponse reponse) {
	  String name = request.getParameter("name");
	  return name;
	
	     }
}