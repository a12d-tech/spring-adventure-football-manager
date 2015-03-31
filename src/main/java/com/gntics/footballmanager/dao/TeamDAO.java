package com.gntics.footballmanager.dao;

import java.util.Collection;

import com.gntics.footballmanager.model.Team;

public interface TeamDAO {
	
	public Collection<Team> findAll();
	
	public Team findById(int id);
	
	void save(Team t);

}
