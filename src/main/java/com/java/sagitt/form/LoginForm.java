package com.java.sagitt.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty
	@Size(min = 1, max = 50)
	private String username;

	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;

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

}
