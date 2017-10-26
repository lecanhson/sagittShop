package com.java.sagitt.service;

import com.java.sagitt.enties.User;
import com.java.sagitt.helper.BusinessException;

public interface UserMgr {

	User login(String userName, String email, String pwd) throws BusinessException;
}
