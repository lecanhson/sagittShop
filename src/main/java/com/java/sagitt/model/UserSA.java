package com.java.sagitt.model;

import java.io.Serializable;
import java.util.Date;


public class UserSA implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String user;
	private String password;
	private String email;
	private Date create;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
