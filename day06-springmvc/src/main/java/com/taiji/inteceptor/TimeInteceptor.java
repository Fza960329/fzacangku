package com.taiji.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeInteceptor implements HandlerInterceptor {

		private Long startTime;
		
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			// TODO Auto-generated method stub
			System.err.println("time preHandle comming");
			startTime=System.currentTimeMillis();
			return true;
		}

		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("TimeInteceptor postHandle comming");

		}

		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("TimeInteceptor afterCompletion comming");
		}

	}



