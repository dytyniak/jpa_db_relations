package com.jobsukraine.onetoone.unidirectional;

import javax.persistence.EntityManager;

import com.jobsukraine.Connection;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = new Connection("root", "admin", "192.168.1.107", "relations");
		EntityManager entitymanager = conn.getManager();
		
		People people[] = {
				new People("Taras", "Rakochy", "Horodozka, 404"),
				new People("Roman", "Derkach", "Striyska, 50"),
				new People("Oleg", "Kardash", "Luchakivska, 20"),
				new People("Vadim", "Dytyniak", "Chernivezka, 10"),
				new People("Volodya", "Chornenkiy", "Zamarstunivska, 10") 
				};
		
		Phone phones[] = { 
				new Phone("9481283296"),
				new Phone("7364950662"),
				new Phone("9128509982"),
				new Phone("4152637599"), 
				new Phone("4253586942")
				};
		
		entitymanager.getTransaction().begin();
		
		for (int i = 0; i < phones.length; i++) {
			entitymanager.persist(phones[i]);
			people[i].setPhone(phones[i]);
			entitymanager.persist(people[i]);
		}
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}

}
