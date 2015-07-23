package com.jobsukraine.onetomany.unidirectional.manytoone;

import javax.persistence.*;

import java.util.List;

public class CategoryService {
	
	protected EntityManager em;

	public CategoryService(EntityManager em) {
		this.em = em;
	}

	public Category createEmployee(String name) {
		em.getTransaction().begin();
		Category category = new Category(name);
		em.persist(category);
		em.getTransaction().commit();
		return category;

	}

	public void removeCategory(long id) {
		em.getTransaction().begin();
		Category category = findCategory(id);
		if (category != null) {
			em.remove(category);
		}
		em.getTransaction().commit();
	}

	public Category findCategory(long id) {
		return em.find(Category.class, id);
	}
	
	public Category findCategory(String name) {
		TypedQuery<Category> query = em.createQuery(
			"SELECT c FROM Category c WHERE c.name=:name", Category.class);
		query.setParameter("name", name);
				return query.getSingleResult();
	}

	public List<Category> findAllCategories() {
		TypedQuery<Category> query = em.createQuery(
		"SELECT c FROM Category c", Category.class);
		return query.getResultList();
		
	}

}
