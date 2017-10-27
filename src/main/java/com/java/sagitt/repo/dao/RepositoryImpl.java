package com.java.sagitt.repo.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.sagitt.helper.DataAccessException;

/**
 * @author thanhtc
 * 
 */
public class RepositoryImpl implements IRepository {

	@Override
	public <T> T getEntityBySQL(Class<T> clazz, String sql, List<Object> params) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getEntityBySQL(Class<T> clazz, String sql, List<Object> params, List<Class<?>> synchronizedClass)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
