package com.jobsukraine.onetomany.unidirectional.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GrouppService {

	private EntityManager em;

	public GrouppService(EntityManager em) {
		this.em = em;
	}

	public void add(String name) {
		em.getTransaction().begin();
		Groupp g = new Groupp(name);
		em.persist(g);
		em.getTransaction().commit();
	}

	public Groupp find(String name) {
		TypedQuery<Groupp> tq = em.createQuery("select g from Groupp g where g.name = :name", Groupp.class);
		return tq.setParameter("name", name).getSingleResult();
	}

	public List<Groupp> getAll() {
		TypedQuery<Groupp> tq = em.createQuery("select g from Groupp g", Groupp.class);
		return tq.getResultList();
	}

}
