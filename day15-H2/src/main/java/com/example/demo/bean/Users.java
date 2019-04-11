package com.example.demo.bean;

public class Users {
	private String username;
	private String password;
	private Boolean enabled;
	private String phone;
	private String email;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String password, Boolean enabled, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.phone = phone;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	

}
