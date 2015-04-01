package com.gntics.footballmanager.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gntics.footballmanager.model.Team;

@Repository
public class TeamDAOImpl implements TeamDAO{

  @PersistenceContext
  private EntityManager em;

  public Team findById(int id) {

    Query q = this.em.createQuery("SELECT team FROM Team team WHERE team.id = :id");
    q.setParameter("id", id);

    return (Team) q.getSingleResult();
  }

  public void save(Team team) {
    if (team.getId() == null) {
      this.em.persist(team);
    }
    else {
      this.em.merge(team);
    }
  }

  @SuppressWarnings("unchecked")
  public Collection<Team> findAll() {

    Query q = this.em.createQuery("SELECT distinct team FROM Team team");

    return q.getResultList();
  }

}
