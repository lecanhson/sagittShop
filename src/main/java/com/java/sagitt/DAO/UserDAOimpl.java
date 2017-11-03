package com.java.sagitt.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.sagitt.enties.User;
import com.java.sagitt.helper.DataAccessException;
import com.java.sagitt.repo.dao.IRepository;

public class UserDAOimpl implements UserDAO {
	
	@Autowired
	private IRepository repo;

	@Override
	public User login(String userName, String email, String pwd) throws DataAccessException {
		List<Object> params = new ArrayList<Object>();
		String sql = "select * from user where user_name = ? and password = ? ";
		/*params.add(StringUtility.isNullOrEmpty(email) ? userName : email);*/
		params.add(userName);
		params.add(pwd);
		return repo.getEntityBySQL(User.class, sql, params);
	}

}
