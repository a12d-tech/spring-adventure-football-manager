package com.gntics.footballmanager.service;

import java.util.Collection;

import com.gntics.footballmanager.model.Player;
import com.gntics.footballmanager.model.Team;

public interface FootballManagerService {

  /*
   * TEAM
   */
  Collection<Team> findAllTeams();

  Team findTeamById(int id);

  void saveTeam(Team team);

  /*
   * PLAYER
   */
  Collection<Player> findAllPlayers();

  Player findPlayerById(int id);

  void savePlayer(Player player);

}
