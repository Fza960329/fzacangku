package com.example.bean;

public class bean02 {
	private String name;
	private String Id;
	
public void start() {
	System.out.println("初始化方法");
}
public void stop() {
	System.out.println("销毁方法");
}
public bean02() {
	super();
	// TODO Auto-generated constructor stub
}
public bean02(String name, String id) {
	super();
	this.name = name;
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
	
	
}
