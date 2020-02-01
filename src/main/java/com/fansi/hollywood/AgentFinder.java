package com.fansi.hollywood;

import java.util.List;

public interface AgentFinder {
	public List<Agent> findAllAgents();

	public void setAgents(List<Agent> resource);

	public void clear();
}
