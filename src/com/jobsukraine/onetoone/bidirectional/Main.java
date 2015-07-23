package com.jobsukraine.onetoone.bidirectional;

import javax.persistence.EntityManager;

import com.jobsukraine.Connection;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = new Connection("root", "admin", "192.168.1.107", "relations");
		EntityManager entitymanager = conn.getManager();
		
		Person persons[] = { 
				new Person("Taras", "Rakochy"),
				new Person("Roman", "Derkach"), 
				new Person("Oleg", "Kardash"),
				new Person("Vadim", "Dytyniak"),
				new Person("Volodya", "Chornenkiy") 
				};
		
		MobilePhone phones[] = { 
				new MobilePhone("9481283296"), 
				new MobilePhone("7364950662"), 
				new MobilePhone("9128509982"),
				new MobilePhone("4152637599"),
				new MobilePhone("4253586942") 
				};
		
		entitymanager.getTransaction().begin();
		
		for (int i = 0; i < phones.length; i++) {
			entitymanager.persist(phones[i]);
			persons[i].setMobilePhone(phones[i]);
			entitymanager.persist(persons[i]);
		}
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}

}
