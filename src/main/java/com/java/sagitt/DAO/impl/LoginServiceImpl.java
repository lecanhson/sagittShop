package com.java.sagitt.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.sagitt.DAO.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired

	@Override
	public boolean checkLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		return false;
	}

}
