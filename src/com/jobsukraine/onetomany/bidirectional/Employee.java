package com.jobsukraine.onetomany.bidirectional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id @GeneratedValue
	private long id;
	
	private String lastName;
	
	private String firstName;
	
	private long salary;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	public Employee() {
	
	}
	
	public Employee(String lastName, String firstName, long salary) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary=salary;
	}
	
	public Employee(String lastName, String firstName, long salary,  Department department) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary=salary;
		this.department = department;
	}

	public long getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}	
	
	@Override
	public String toString() {
		return id + " " + lastName + " " + firstName + " " + salary + " " + department;
	}
}
