package com.jobsukraine.manytomany.unidirectional;

import javax.persistence.EntityManager;

public class Service {

	EntityManager em;

	public Service(EntityManager em) {
		super();
		this.em = em;
	}

	public Service() {

	}

	

	/* SERVICES FOR USER!!! */

	public void saveUser(User user) {
		if (getUserByName(user.getName()) == null) {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} else {
			System.out.println("User with this name already exist!!!");
		}

	}

	public User getUserByName(String name) {
		return em.createNamedQuery("User.getbyName", User.class).setParameter("name", name).getSingleResult();

	}

	/* SERVICES FOR PROGRAM!!! */

	public void saveProgram(Program p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
	}
	
	public Program getProgramByName(String name) {
		return em.createNamedQuery("Program.getName", Program.class).setParameter("name", name).getSingleResult();
		
	}
}
