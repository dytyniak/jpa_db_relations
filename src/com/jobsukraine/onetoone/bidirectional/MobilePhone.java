package com.jobsukraine.onetoone.bidirectional;

import javax.persistence.*;

@Entity
public class MobilePhone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String number;
	
	@OneToOne(mappedBy = "mobilePhone")
	private Person person;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public MobilePhone() {
		
	}

	public MobilePhone(String number) {
		super();
		this.number = number;
	}
	
	
	
}
