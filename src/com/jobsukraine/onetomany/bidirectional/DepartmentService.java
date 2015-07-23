package com.jobsukraine.onetomany.bidirectional;

import javax.persistence.EntityManager;

public class DepartmentService {
	
	private EntityManager em;
	
	public DepartmentService(EntityManager em) {
		this.em=em;
	}
	
	public Department createDepartment(String name) {
		em.getTransaction().begin();
		Department dep = new Department(name);
		em.persist(dep);
		em.getTransaction().commit();
		return dep;

	}
	
	public Department findDepartment(long id) {
		return em.find(Department.class, id);
	}
}
