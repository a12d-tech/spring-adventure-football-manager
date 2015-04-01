package com.gntics.footballmanager.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.gntics.footballmanager.dao.TeamDAO;
import com.gntics.footballmanager.model.Team;

@Service
public class FootballManagerServiceImpl implements FootballManagerService {
	
	@Autowired
	private TeamDAO teamDAO;
	
	@Transactional
	public Collection<Team> findAllTeams() {
		return teamDAO.findAll();
	}

	@Transactional
	public Team findTeamById(int id) {
		return teamDAO.findById(id);
	}

	@Transactional
	public void saveTeam(Team team) {
		teamDAO.save(team);
	}

}
