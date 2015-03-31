package com.gntics.footballmanager.service;

import java.util.Collection;

import com.gntics.footballmanager.model.Team;

public interface FootballManagerService {
	
	Collection<Team> findAllTeams();
	
	Team findTeamById(int id);
	
	void saveTeam(Team t);

}
