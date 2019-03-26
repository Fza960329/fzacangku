package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExampleBean {
	@Autowired
//	@Qualifier("aaa")
	private AnotherBean beanOne;

	@Autowired
	private YetAnotherBean beanTwo;


	public ExampleBean() {
		
	}
	
	@Autowired
	public ExampleBean(AnotherBean beanOne, YetAnotherBean beanTwo) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
	}
	
	public void setBeanOne(AnotherBean beanOne) {
		this.beanOne = beanOne;
	}
	
	public void setBeanTwo(YetAnotherBean beanTwo) {
		this.beanTwo = beanTwo;
	}

	public AnotherBean getBeanOne() {
		return beanOne;
	}

	public YetAnotherBean getBeanTwo() {
		return beanTwo;
	}

}
