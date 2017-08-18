package com.java.sagitt.learn;

import org.springframework.aop.config.AspectEntry;
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
/*public aspect LogDataAccsessAspect {
	 private Log log = new Log();
	 
	 pointcut dataAcessExcution () : (execution (public * Data))
}*/
