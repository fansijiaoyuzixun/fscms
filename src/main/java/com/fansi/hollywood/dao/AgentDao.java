package com.fansi.hollywood.dao;

import java.util.List;

import com.fansi.hollywood.Agent;

public interface AgentDao extends BaseDao{
	@Override
	public List<Agent> findAll();
}
