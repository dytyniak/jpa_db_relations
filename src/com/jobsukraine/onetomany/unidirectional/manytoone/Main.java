package com.jobsukraine.onetomany.unidirectional.manytoone;

import javax.persistence.EntityManager;

import com.jobsukraine.Connection;

public class Main {

	public static void main(String[] args) {
		Connection connection = new Connection("root", "admin", "192.168.1.107", "relations", false);
		EntityManager em = connection.getManager();

		ProductService ps = new ProductService(em);
		CategoryService cs = new CategoryService(em);

		Category c = cs.create("Other");
		ps.add("apple", 10, c);
		ps.add("bread", 5, c);
		System.out.println(ps.getAll());

		Category c1 = cs.create("Vegetables");
		ps.add("potato", 10, c1);
		System.out.println(ps.getAll());

		System.out.println(cs.findAllCategories());
	}

}
