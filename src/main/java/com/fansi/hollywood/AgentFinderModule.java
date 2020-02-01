package com.fansi.hollywood;

import com.google.inject.AbstractModule;

public class AgentFinderModule extends AbstractModule {


	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(AgentFinder.class).to(SimpleAgentFinder.class);
	}

}
