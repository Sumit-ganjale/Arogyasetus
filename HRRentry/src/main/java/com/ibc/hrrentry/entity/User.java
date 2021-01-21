package com.ibc.hrrentry.entity;


public class User {
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String address;
	private Long contactNo;

	
	
	
	public User(String firstname, String lastname, String username, String password, String address, Long contactNo) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
	}




	public String getName() {
		return firstname;
	}




	public void setName(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
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




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public Long getContactNo() {
		return contactNo;
	}




	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}




	


	

	

}
