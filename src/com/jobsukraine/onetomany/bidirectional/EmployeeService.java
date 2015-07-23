package com.jobsukraine.onetomany.bidirectional;

import javax.persistence.*;

import java.util.List;

public class EmployeeService {
	protected EntityManager em;

	public EmployeeService(EntityManager em) {
		this.em = em;
	}

	public Employee createEmployee(String lastName, String firstName, long salary, Department department) {
		em.getTransaction().begin();
		Employee emp = new Employee(lastName, firstName, salary, department);
		em.persist(emp);
		em.getTransaction().commit();
		return emp;

	}
	
	public Employee createEmployee(String lastName, String firstName, long salary) {
		em.getTransaction().begin();
		Employee emp = new Employee(lastName, firstName, salary);
		em.persist(emp);
		em.getTransaction().commit();
		return emp;

	}

	public void removeEmployee(long id) {
		em.getTransaction().begin();
		Employee emp = findEmployee(id);
		if (emp != null) {
			em.remove(emp);
		}
		em.getTransaction().commit();
	}


	public Employee findEmployee(long id) {
		return em.find(Employee.class, id);
	}

	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = em.createQuery(
		"SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
		
	}

}
