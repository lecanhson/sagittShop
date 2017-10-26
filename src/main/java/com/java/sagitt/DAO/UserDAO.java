package com.java.sagitt.DAO;

import com.java.sagitt.enties.User;
import com.java.sagitt.helper.DataAccessException;

public interface UserDAO {
	
	User login(String userName,String email,String pwd) throws DataAccessException;

}
