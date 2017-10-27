package com.java.sagitt.repo.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.sagitt.helper.DataAccessException;

/**
 * @author canhson
 * 
 */
public class RepositoryImpl implements IRepository {

	@Autowired
	private SelectRepository selectRepo;

	@Autowired
	private InsertRepository insertRepo;

	@Override
	public <T> T getEntityById(Class<T> clazz, Serializable id, boolean oneSession) throws DataAccessException {
		return null;
	}

	@Override
	public <T> T getEntityBySQL(Class<T> clazz, String sql, List<Object> params) throws DataAccessException {
		return selectRepo.getEntityBySQL(clazz, sql, params);
	}

	@Override
	public <T> T getEntityBySQL(Class<T> clazz, String sql, List<Object> params, List<Class<?>> synchronizedClass)
			throws DataAccessException {
		return selectRepo.getEntityBySQL(clazz, sql, params);
	}

	@Override
	public <T> T getEntityByHQL(String hql, List<Object> params) throws DataAccessException {
		return null;
	}

}
