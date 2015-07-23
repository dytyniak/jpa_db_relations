package com.jobsukraine.onetomany.bidirectional;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id @GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employees;

	public Department() {
		
	}
	
	public Department(String name) {
		this.name = name;
	}
	
	public Department(String name, List<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		return id + " " + name;
	}
}
