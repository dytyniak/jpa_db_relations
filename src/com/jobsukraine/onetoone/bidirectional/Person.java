package com.jobsukraine.onetoone.bidirectional;

import javax.persistence.*;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	private String name;
	
	private String lastName;
	
	@OneToOne
	private MobilePhone mobilePhone;

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

	public MobilePhone getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(MobilePhone mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	public Person() {
		
	}

	public Person(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	
	

	
	
}
