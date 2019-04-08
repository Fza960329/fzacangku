package com.taiji.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.taiji.inteceptor.LoginInInterceptor;
import com.taiji.inteceptor.TimeInteceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.lessons.controller")
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(new LoginInteceptor());
		registry.addInterceptor(new TimeInteceptor());
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	   registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
       registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/css/**").addResourceLocations("classpath:/statics/css/");
	  registry.addResourceHandler("/js/**").addResourceLocations("classpath:/statics/js/");
	}


	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("message");
	    return messageSource;
	}
}
