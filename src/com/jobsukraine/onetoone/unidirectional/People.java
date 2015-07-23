package com.jobsukraine.onetoone.unidirectional;

import javax.persistence.*;

@Entity
public class People {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	private String name;

	private String lastName;
	
	private String address;

	@OneToOne
	Phone phone;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public People() {

	}

	public People(String name, String lastName, String address) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
	}

}
