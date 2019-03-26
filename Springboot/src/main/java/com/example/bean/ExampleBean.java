package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ExampleBean {
 @Autowired
 private YetAnotherBean beanTwo;
 
 public ExampleBean() {
	 
 }
 @Autowired
 public ExampleBean(AnotherBean beanOne,YetAnotherBean beanTwo) {
  super();
  
  this.beanTwo=beanTwo;
 }
 
 
 
 }
 
	


