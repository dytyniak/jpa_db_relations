package com.jobsukraine.onetomany.unidirectional.manytoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProductService {

	private EntityManager em;

	public ProductService(EntityManager em) {
		this.em = em;
	}

	public void add(String name, long price, Category c) {
		em.getTransaction().begin();
		Product p = new Product(name,price,c);
		em.persist(p);
		em.getTransaction().commit();		
	}

	public Product find(String type, String name, long price) {
		TypedQuery<Product> tq = em.createQuery(
				" select p from product p where p.name = :name and p.type = :type and p.price = :price", Product.class);
		return tq.setParameter("name", name).setParameter("type", type).setParameter("price", price).getSingleResult();
	}

	public List<Product> getAll() {
		TypedQuery<Product> tq = em.createQuery("select p from Product p", Product.class);
		return tq.getResultList();
	}

}
