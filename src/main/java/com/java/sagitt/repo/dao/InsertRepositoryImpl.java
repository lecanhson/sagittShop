package com.java.sagitt.repo.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;



public class InsertRepositoryImpl extends AbstractRepository implements InsertRepository {
	
	/** The session factory. */
	private SessionFactory insertSessionFactory;
	
	public InsertRepositoryImpl(SessionFactory insertSessionFactory) {
		this.insertSessionFactory = insertSessionFactory;
	}
	
	
}
