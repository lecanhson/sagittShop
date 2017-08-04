package com.java.sagitt.learn;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {

	@Autowired
	private Person person;

	private int type;

	private String action;

	@Autowired
	public void setPerson(Person person) {
		this.person = person;
	}
}
