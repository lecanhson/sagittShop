package com.java.sagitt.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.sagitt.DAO.UserDAO;
import com.java.sagitt.enties.User;
import com.java.sagitt.helper.BusinessException;
import com.java.sagitt.helper.DataAccessException;

public class UserMgrImpl implements UserMgr{
	
	@Autowired
	UserDAO userDao;

	@Override
	public User login(String userName, String email, String pwd) throws BusinessException {
		try {
					
			return userDao.login(userName, email, pwd);			
		} catch (DataAccessException e) {
			throw new BusinessException(e);
		}
	}

}
