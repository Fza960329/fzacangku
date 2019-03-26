package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextTest {
  private AbstractApplicationContext context;
  public ApplicationContextTest() {
	  context= new FileSystemXmlApplicationContext("classpath:/META-INF/application-context.xml");
	  context.registerShutdownHook();
	  
  
	  
  }
}
