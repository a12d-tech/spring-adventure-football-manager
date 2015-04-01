package com.gntics.footballmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "player")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "first_name")
  @NotEmpty
  private String firstname;

  @Column(name = "last_name")
  @NotEmpty
  private String lastname;

  @Column(name = "role")
  @NotEmpty
  private String role;

  @Column(name = "age")
  @NotNull
  @Min(0)
  @Max(100)
  private Integer age;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  // Constructors
  public Player() {} // hibernate require a default constructor

  public Player(String firstname, String lastname, Integer age, String role) {
    this.firstname = firstname;
    this.lastname  = lastname;
    this.age       = age;
    this.role      = role;
  }

  // Getters and Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

}
