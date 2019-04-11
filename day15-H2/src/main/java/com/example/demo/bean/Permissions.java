package com.example.demo.bean;

public class Permissions {
	private String authority;
	private String url;
	public Permissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permissions(String authority, String url) {
		super();
		this.authority = authority;
		this.url = url;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Permissions [authority=" + authority + ", url=" + url + "]";
	}
	
}
