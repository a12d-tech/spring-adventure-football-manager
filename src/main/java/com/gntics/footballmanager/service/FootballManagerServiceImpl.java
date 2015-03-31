package com.gntics.footballmanager.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.gntics.footballmanager.dao.TeamDAO;
import com.gntics.footballmanager.model.Team;

@Service
public class FootballManagerServiceImpl implements FootballManagerService {
	
	private TeamDAO teamDAO;
	
	@Autowired
	public FootballManagerServiceImpl(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	@Override
	@Transactional
	public Collection<Team> findAllTeams() {
		return teamDAO.findAll();
	}

	@Override
	@Transactional
	public Team findTeamById(int id) {
		return teamDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveTeam(Team team) {
		teamDAO.save(team);
	}

}
