package com.fansi.hollywood;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

public class HollywoodServiceGuice {
	private AgentFinder finder = null;

	@Inject
	public HollywoodServiceGuice(AgentFinder finder) {
		this.finder = finder;
	}

	public List<Agent> getFriendlyAgentsBy(String key) {
		// TODO Auto-generated method stub
		// 查找对Java开发者友好的星探
		List<Agent> agents = finder.findAllAgents();
		List<Agent> result = filtefrindlyAgents(key, agents);
		return result;
	}

	private List<Agent> filtefrindlyAgents(String key, List<Agent> agents) {
		if (agents == null || agents.size() == 0) {
			throw new NotFoundFriendlyAgentExcpetion();
		}
		List<Agent> result = new ArrayList<Agent>();
		for (Agent agent : agents) {
			if (agent.getType().equals(key)) {
				result.add(agent);
			}
		}
		return result;
	}

	public void addAgents(List<Agent> resource) {
		// TODO Auto-generated method stub
		finder.setAgents(resource);
	}

	public void clearAllAgents() {
		// TODO Auto-generated method stub
		finder.clear();
	}

}
