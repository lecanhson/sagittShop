package com.java.sagitt.repo.dao;

import java.io.Serializable;

import com.java.sagitt.helper.DataAccessException;

public interface IRepository extends SelectRepository, InsertRepository {

	<T> T getEntityById(Class<T> clazz, Serializable id, boolean oneSession) throws DataAccessException;

}
