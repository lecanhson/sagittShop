package com.java.sagitt.service;

import com.java.sagitt.helper.BusinessException;
import com.java.sagitt.model.UserSA;

public interface UserMgr {

	UserSA login(String userName, String email, String pwd) throws BusinessException;
}
