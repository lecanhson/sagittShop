package com.java.sagitt.repo.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.sagitt.helper.DataAccessException;

public class SelectRepositoryImpl extends AbstractRepository implements SelectRepository {

	private SessionFactory selectSessionFactory;
	
	public SelectRepositoryImpl(SessionFactory selectSessionFactory) {
		this.selectSessionFactory = selectSessionFactory;
	}

	@Override
	public <T> T getEntityBySQL(Class<T> clazz, String sql, List<Object> params, List<Class<?>> synchronizedClass)
			throws DataAccessException {
		try {
			Session session = selectSessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery(sql);
			addParameters(query, params);
			addSynchronizedClass(query, synchronizedClass);
			query.setCacheable(true);
			query.addEntity(clazz);
			query.setMaxResults(1);
			return clazz.cast(query.uniqueResult());
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public <T> T getEntityByHQL(String hql, List<Object> params) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getEntityBySQL(Class<T> clazz, String sql, List<Object> params) throws DataAccessException {
		return getEntityBySQL(clazz, sql, params, null);
	}
	

}
