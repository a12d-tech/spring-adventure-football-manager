package com.gntics.footballmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "player")
public class Player {

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
	@NotEmpty
	private Integer age;
	
	@ManyToOne
    @JoinColumn(name = "owner_id")
    private Team team;

	// Getters and Setters
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
