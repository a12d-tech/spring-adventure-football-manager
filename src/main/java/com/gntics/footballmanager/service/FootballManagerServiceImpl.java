package com.gntics.footballmanager.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gntics.footballmanager.dao.PlayerDAO;
import com.gntics.footballmanager.dao.TeamDAO;
import com.gntics.footballmanager.model.Player;
import com.gntics.footballmanager.model.Team;

@Service
public class FootballManagerServiceImpl implements FootballManagerService {

  private TeamDAO teamDAO;
  private PlayerDAO playerDAO;

  @Autowired
  public FootballManagerServiceImpl(TeamDAO teamDAO, PlayerDAO playerDAO) {
    this.teamDAO   = teamDAO;
    this.playerDAO = playerDAO;
  }

  /*
   * TEAM
   */

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

  /*
   * PLAYER
   */

  @Transactional
  public Collection<Player> findAllPlayers() {
    return playerDAO.findAll();
  }

  @Transactional
  public Player findPlayerById(int id) {
    return playerDAO.findById(id);
  }

  @Transactional
  public void savePlayer(Player player) {
    playerDAO.save(player);
  }

}
