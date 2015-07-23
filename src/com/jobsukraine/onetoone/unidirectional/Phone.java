package com.jobsukraine.onetoone.unidirectional;

import javax.persistence.*;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Phone() {
		
	}

	public Phone(String number) {
		super();
		this.number = number;
	}
}
