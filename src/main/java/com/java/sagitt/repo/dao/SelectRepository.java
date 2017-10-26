package com.java.sagitt.repo.dao;

import java.util.List;

import com.java.sagitt.helper.DataAccessException;

public interface SelectRepository {
	
	<T> T getEntityBySQL(Class<T> clazz, String sql, List<Object> params) throws DataAccessException;
	

	<T> T getEntityBySQL(Class<T> clazz, String sql, List<Object> params, List<Class<?>> synchronizedClass)
			throws DataAccessException;

}
