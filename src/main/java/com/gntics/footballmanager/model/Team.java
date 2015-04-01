package com.gntics.footballmanager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "team")
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  @NotEmpty
  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "team", fetch = FetchType.EAGER)
  private Set<Player> players;

  // Methods
  public void addPlayer(Player player){
    Set<Player> players = getPlayers();
    players.add(player);
    player.setTeam(this);
  }

  // Constructor
  public Team() { }

  public Team(String name) {
    this.name = name;
  }

  // Getters and Setters
  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Player> getPlayers() {
    if (this.players == null) {
      this.players = new HashSet<Player>();
    }
    return this.players;
  }

  public void setPlayers(Set<Player> players) {
    this.players = players;
  }
  
  public boolean isNew() {
    return (this.id == null);
  }

}
