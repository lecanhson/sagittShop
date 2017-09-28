package com.java.sagitt.DAO.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.java.sagitt.DAO.LoginDAO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Resource(name = "sessionFacory")
	protected SessionFactory sessionfactory;

	@Override
	public boolean checkLogin(String userName, String passWord) {
		Session session = sessionfactory.openSession();
		boolean userFound = false;
		String HQL = "from Users as o where o.userName=? and o.userPassword=?";
		Query query = session.createQuery(HQL);
		query.setParameter(0, userName);
		query.setParameter(1, passWord);
		List list = query.list();
		if (list != null && list.size() > 0) {
			userFound = true;
		}
		session.close();
		return userFound;
	}

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

}
