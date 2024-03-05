package com.jwt.dto;

public class SignUpDto {

    Long id;
	String name;
	String gender;
	String emailId;
	String phoneNumber;
	String password;
	
	
	
	public SignUpDto(Long id, String name, String gender, String emailId, String phoneNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	
	
	public SignUpDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", password=" + password + "]";
	}
}
