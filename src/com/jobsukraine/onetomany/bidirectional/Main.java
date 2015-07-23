package com.jobsukraine.onetomany.bidirectional;

import java.util.List;

import javax.persistence.EntityManager;

import com.jobsukraine.Connection;

public class Main {

	public static void main(String[] args) {
		Connection connection = new Connection("root", "admin", "192.168.1.107", "relations");
		EntityManager em = connection.getManager();
		EmployeeService es = new EmployeeService(em);
		DepartmentService ds = new DepartmentService(em);
		
		//es.createEmployee("Dytyniak", "Vadym", 1000, ds.createDepartment("JobsUkraine"));
		//es.createEmployee("Black", "Vova", 1000, ds.createDepartment("JobsUkraine"));
		//es.createEmployee("Kardash", "Oleh", 1000, ds.createDepartment("JobsUkraine"));
		
		em.getTransaction().begin();
		Employee employee = new Employee("Derkach2","Roman2", 3020);
		Department department = ds.findDepartment(1L);
		
		               //THE SAME RESULT//
		
		/*List<Employee> employees = department.getEmployees();
		employees.add(employee);
		department.setEmployees(employees);*/
		
					//THE SAME RESULT//
		
		employee.setDepartment(department);
		em.persist(employee);
		System.out.println(department.getEmployees());
		em.getTransaction().commit();
	}

	
}
