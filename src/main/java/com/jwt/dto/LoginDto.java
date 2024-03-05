package com.jwt.dto;

public class LoginDto {
	
	String emailId;
	String password;
	
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [email=" + emailId + ", password=" + password + "]";
	}
	
	

}
