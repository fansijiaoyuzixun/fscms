package com.fansi.hollywood;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.inject.Guice;
import com.google.inject.Injector;

@SpringBootTest
public class HollywoodServiceBeInjectSimpleAgengFinderTest {
	private static final int OnlyOne = 1;
	private static final int MultiFriendlyAgentsNumber = 3;
	static Injector injector;
	static HollywoodServiceGuice hollywoodService;
	static final String deveplorer = "Java Deveplorer";

	@BeforeClass
	public static void init() {
		injector = Guice.createInjector(new AgentFinderModule());
		hollywoodService = injector.getInstance(HollywoodServiceGuice.class);
	}

	@Before
	public void setUp() {
		hollywoodService.clearAllAgents();
	}

	/**
	 * 测试没有友好星探的情况
	 */
	@Test(expected=NotFoundFriendlyAgentExcpetion.class)
	public void emptyFriendlyAgents() {
		initTestFriendlyAgents(getEmpyFriendlyAgentList());
		hollywoodService.getFriendlyAgentsBy(deveplorer);	
	}

	/**
	 * 测试有一位友好星探的情况
	 */
	@Test
	public void OnlyOneFriendlyAgent() {
		initTestFriendlyAgents(getContainsOnlyOneFriendlyAgentList());
		List<Agent> agents = hollywoodService.getFriendlyAgentsBy(deveplorer);
		assertTrue(agents.size() == OnlyOne);
		assertEquals(agents.get(0).getType(), deveplorer);
	}

	/**
	 * 测试有多位星探的情况
	 */
	@Test
	public void multiFriendlyAgents() {
		initTestFriendlyAgents(getMultiFriendlyAgentsList());
		List<Agent> agents = hollywoodService.getFriendlyAgentsBy(deveplorer);
		assertTrue(agents.size() == MultiFriendlyAgentsNumber);
		assertEquals(agents.get(0).getType(), deveplorer);
		assertEquals(agents.get(2).getType(), deveplorer);
	}

	
	/**
	 * 获取多个友好星探的列表
	 * @return
	 */
	private List<Agent> getMultiFriendlyAgentsList() {
		// TODO Auto-generated method stub
		List<Agent> agents = new ArrayList<Agent>();
		setMultiFriendlyAgentEntities(agents);	
		return agents;
	}
	
	/**
	 * 设置多个友好星探实体集合
	 * @param agents
	 */
	private void setMultiFriendlyAgentEntities(List<Agent> agents) {
		for (int i = 0; i < MultiFriendlyAgentsNumber; i++) {
			Agent a1 = new Agent();
			a1.setType(deveplorer);
			agents.add(a1);
		}		
	}
	
	private List<Agent> getEmpyFriendlyAgentList() {
		return new ArrayList<Agent>();
	}

	private List<Agent> getContainsOnlyOneFriendlyAgentList() {
		List<Agent> expected = getEmpyFriendlyAgentList();
		expected.add(createOneFriendlyAgent());
		return expected;
	}

	private Agent createOneFriendlyAgent() {
		Agent agent = new Agent();
		agent.setType(deveplorer);
		return agent;
	}

	private void initTestFriendlyAgents(List<Agent> source) {
		hollywoodService.addAgents(source);
	}

}
