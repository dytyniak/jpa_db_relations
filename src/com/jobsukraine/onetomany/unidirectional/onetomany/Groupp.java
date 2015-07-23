package com.jobsukraine.onetomany.unidirectional.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Groupp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	@OneToMany
	@JoinColumn(name = "group_id")
	private List<Student> students;

	public Groupp() {
		// TODO Auto-generated constructor stub
	}

	public Groupp(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Groupp [id=" + id + ", name=" + name + ", students=" + students+"]\n";
	}
}
