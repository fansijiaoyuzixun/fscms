package com.fansi.hollywood;

import java.util.ArrayList;
import java.util.List;

public class SimpleAgentFinder implements AgentFinder  {

	List<Agent> tmpDBAgents = new ArrayList<Agent>();
	
	@Override
	public List<Agent> findAllAgents() {
		// TODO Auto-generated method stub
		return tmpDBAgents;
	}

	@Override
	public void setAgents(List<Agent> resource) {
		// TODO Auto-generated method stub
		tmpDBAgents.addAll(resource);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		tmpDBAgents.clear();
	}
	
	

}
