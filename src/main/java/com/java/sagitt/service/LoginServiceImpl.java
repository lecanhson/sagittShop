package com.java.sagitt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.sagitt.DAO.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginDAO {
	
	@Autowired
	private LoginDAO login;
	
	
	public LoginDAO getLogin() {
		return login;
	}


	public void setLogin(LoginDAO login) {
		this.login = login;
	}

	@Override
	public boolean checkLogin(String userName, String passWord) {
		System.out.println("Đang kiểm tra quá trình, vui lòng chờ trong giây lát");
		return login.checkLogin(userName, passWord);
	}

}
