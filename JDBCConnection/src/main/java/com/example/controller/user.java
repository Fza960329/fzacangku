package com.example.controller;

import org.springframework.stereotype.Component;

@Component
public class user {
	
	private String gclass;
	private String gteacher;
	private String gstudent;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(String gclass, String gteacher, String gstudent) {
		super();
		this.gclass = gclass;
		this.gteacher = gteacher;
		this.gstudent = gstudent;
	}
	public String getGclass() {
		return gclass;
	}
	public void setGclass(String gclass) {
		this.gclass = gclass;
	}
	public String getGteacher() {
		return gteacher;
	}
	public void setGteacher(String gteacher) {
		this.gteacher = gteacher;
	}
	public String getGstudent() {
		return gstudent;
	}
	public void setGstudent(String gstudent) {
		this.gstudent = gstudent;
	}
	@Override
	public String toString() {
		return "user [gclass=" + gclass + ", gteacher=" + gteacher + ", gstudent=" + gstudent + "]";
	}
	
	
}
