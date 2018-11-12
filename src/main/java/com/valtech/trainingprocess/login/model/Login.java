package com.valtech.trainingprocess.login.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {

	@NotEmpty(message = "This Field cannot be left empty")
	private String userName;

	@NotEmpty(message = "This Field cannot be left empty")
	private String password;

	private String role;

	public Login() {

	}

	public Login(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}