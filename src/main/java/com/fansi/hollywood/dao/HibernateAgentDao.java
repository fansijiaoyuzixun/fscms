package com.fansi.hollywood.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.fansi.hollywood.Agent;

public class HibernateAgentDao implements AgentDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory factory) {
		// TODO Auto-generated method stub
		sessionFactory = factory;
	}

	public List<Agent> findAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Agent a";
			@SuppressWarnings("unchecked")
			Query<Agent> query = session.createQuery(hql);	
			return query.list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
