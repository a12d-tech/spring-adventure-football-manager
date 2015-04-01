package com.gntics.footballmanager.dao;

import java.util.Collection;

import com.gntics.footballmanager.model.Player;

public interface PlayerDAO {

  public Collection<Player> findAll();

  public Player findById(int id);

  void save(Player player);

}
