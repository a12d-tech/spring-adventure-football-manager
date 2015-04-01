package com.gntics.footballmanager.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gntics.footballmanager.model.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

  @PersistenceContext
  private EntityManager em;

  public Player findById(int id) {

    Query q = this.em.createQuery("SELECT player FROM Player player WHERE player.id = :id");
    q.setParameter("id", id);

    return (Player) q.getSingleResult();
  }

  public void save(Player player) {
    if (player.getId() == null) {
      this.em.persist(player);
    }
    else {
      this.em.merge(player);
    }
  }

  @SuppressWarnings("unchecked")
  public Collection<Player> findAll() {

    Query q = this.em.createQuery("SELECT distinct player FROM Player player");

    return q.getResultList();
  }

}
