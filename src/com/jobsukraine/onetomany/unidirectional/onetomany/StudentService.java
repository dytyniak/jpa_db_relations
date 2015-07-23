package com.jobsukraine.onetomany.unidirectional.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class StudentService {

	private EntityManager em;

	public StudentService(EntityManager em) {
		this.em = em;
	}

	public void add(String name, String surname) {
		em.getTransaction().begin();
		Student s = new Student(name, surname);
		em.persist(s);
		em.getTransaction().commit();
	}

	
	public void add(String name, String surname, String group) {
		em.getTransaction().begin();
		Student s = new Student(name, surname);

		GrouppService gs = new GrouppService(em);
		Groupp g = gs.find(group);
		List<Student> students = g.getStudents();
		if (students == null)
		 	students = new ArrayList<Student>();
		students.add(s);
		g.setStudents(students);

		em.persist(s);
		em.getTransaction().commit();
	}

	public void setGroup(String name, String surname, String group) {
		em.getTransaction().begin();
		Student s = find(name,surname);

		GrouppService gs = new GrouppService(em);
		Groupp g = gs.find(group);
		List<Student> students = g.getStudents();
		if (students == null)
			students = new ArrayList<Student>();
		students.add(s);
		g.setStudents(students);

		em.persist(s);
		em.getTransaction().commit();
	}

	public List<Student> getAll() {
		TypedQuery<Student> tq = em.createQuery("select s from Student s", Student.class);
		return tq.getResultList();
	}

	public Student find(String name, String surname) {
		TypedQuery<Student> tq = em.createQuery("select s from Student s where s.name = :name and s.surname = :surname",
				Student.class);
		return tq.setParameter("name", name).setParameter("surname", surname).getSingleResult();
	}

}
