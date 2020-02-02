package com.fansi.hollywood.dao;

import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.fansi.hollywood.Agent;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;
public class HibernateAgentDaoTest {
	private SessionFactory factory;
	private Session session;
	private Query<Agent> query;
	static String hql = "from Agent a";
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {		
		factory = createMock(SessionFactory.class);
		query = createMock(Query.class);
		session = createMock(Session.class);
	}
	
	@Test
	public void testFindAllAgents() throws Exception {
		List<Agent> agents =new ArrayList<Agent>();
		agents.add(new Agent());
		agents.add(new Agent());
		agents.add(new Agent());
		expect(factory.getCurrentSession()).andReturn(session);
		expect(session.createQuery(hql)).andReturn(query);
		expect(query.list()).andReturn(agents);
		replay(factory,session,query);
		HibernateAgentDao dao = new HibernateAgentDao();
		dao.setSessionFactory(factory);
		assertEquals(agents,dao.findAll());
		verify(factory,session,query);
	}
	
	@Test
	public void testFindAllAgentsReturnEmptyListUponException() throws Exception{
		HibernateException hibernateError = new HibernateException("");
		expect(factory.getCurrentSession()).andReturn(session);
		expect(session.createQuery(hql)).andReturn(query);
		expect(query.list()).andThrow(hibernateError);
		replay(factory,session,query);
		HibernateAgentDao dao = new HibernateAgentDao();
		dao.setSessionFactory(factory);
		try {
			dao.findAll();
		} catch (RuntimeException expected) {
			// TODO: handle exception
			assertSame(hibernateError,expected.getCause());
		}
		verify(factory,session,query);
	}
}
