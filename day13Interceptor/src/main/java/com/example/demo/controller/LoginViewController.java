package com.example.demo.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginViewController {
	//预先设置好的正确的用户名和密码，用于登录验证
	private String rightUserName = "admin";
	private String rightpassWord = "admin";
	/**
	 * 登陆校验
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		if (null == userName || null == userPassword) {
			return "redirect:/";
			
		}
		// 前端传回的密码实际为用户输入的：用户名（小写）+ 密码（小写）组合的字符串生成的值
        // 此处先通过后台保存的正确的用户名和密码计算出正确的值，然后和前端传回来的作比较
        String md5info = rightUserName.toLowerCase() + rightpassWord.toLowerCase();
        String realPassword = DigestUtils.md5DigestAsHex(md5info.getBytes());
        if (!userPassword.equals(realPassword)) {
            return "redirect:/";
        }
 
        // 校验通过时，在session里放入一个标识
        // 后续通过session里是否存在该标识来判断用户是否登录
        request.getSession().setAttribute("userName", "admin");
        return "redirect:/welcome";
    }
 
    /**
     * 注销登录
     *
     * @param request
     * @return
     */
    @RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("userName");
        /*return "redirect:/";*/
        
     /*// 前端传回的密码实际为用户输入的：用户名（小写）+ 密码（小写）组合的字符串生成的md5值
        // 此处先通过后台保存的正确的用户名和密码计算出正确的md5值，然后和前端传回来的作比较
        String md5info = rightUserName.toLowerCase() + rightpassWord.toLowerCase();
        String realPassword = DigestUtils.md5DigestAsHex(md5info.getBytes());
        if (!userPassword.equals(realPassword)) {
            return "redirect:/";
	}
        // 校验通过时，在session里放入一个标识
        // 后续通过session里是否存在该标识来判断用户是否登录
        request.getSession().setAttribute("userName", "admin");*/
        return "redirect:/welcome";
    }
 
    /**
     * 注销登录
     *
     * @param request
     * @return
     */
   /* @RequestMapping("/loginout")
    public String loginOut1(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }*/

	

}
