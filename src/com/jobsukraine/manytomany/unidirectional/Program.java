package com.jobsukraine.manytomany.unidirectional;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "programs")
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String name;
	private Double price;

	@ManyToMany(targetEntity=User.class)
	@JoinTable(name = "programs_users",  
	       joinColumns=@JoinColumn(name="programs_id"), 
	       inverseJoinColumns=@JoinColumn(name="users_id"))
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Program() {

	}

	public Program(String name, Double price) {

		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
}
