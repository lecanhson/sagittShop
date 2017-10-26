package com.java.sagitt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.sagitt.service.UserMgr;

public class AbstractController {

	@Autowired
	protected UserMgr userMgr;
		

}
