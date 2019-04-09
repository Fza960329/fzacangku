package com.example.demo.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    public static final String User_Key = "user";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("Init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		  logger.info("访问到了过滤器，doFilter");
	        HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse rep = (HttpServletResponse) response;
	        HttpSession session = req.getSession(false);
	        if (session != null && session.getAttribute(User_Key) != null) {
	            // session已经存在user，说明已经登录成功, 通过
	            chain.doFilter(request, response);
	        } else {
	            // session不存在user，说明没有登录成功，需要登录
	            response.getWriter().write("please call /login first.");
	            return ;
	        }

	        logger.info("LoginFilter 执行完毕");
	    }
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		  logger.info("destroy");
	}

   
	}

