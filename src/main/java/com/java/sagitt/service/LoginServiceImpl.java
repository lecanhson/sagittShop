package com.java.sagitt.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.sagitt.DAO.LoginService;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginService login;
	
	
	public LoginService getLogin() {
		return login;
	}


	public void setLogin(LoginService login) {
		this.login = login;
	}

	@Override
	public boolean checkLogin(String userName, String passWord) {
		System.out.println("Đang kiểm tra quá trình, vui lòng chờ trong giây lát");
		return login.checkLogin(userName, passWord);
	}

}
