package com.jobsukraine.onetomany.unidirectional.onetomany;

import javax.persistence.EntityManager;

import com.jobsukraine.Connection;

public class Main {

	public static void main(String[] args) {
		Connection conn = new Connection("root", "admin", "192.168.1.107", "relations", false);
		EntityManager em = conn.getManager();

		GrouppService gs = new GrouppService(em);
		StudentService ss = new StudentService(em);

		gs.add("KH-34");
		System.out.println(gs.find("KH-34"));

		ss.add("Volodia", "Chornenkiy", "KH-34");
		ss.add("Bogdan", "Kononchyk", "KH-34");
		ss.add("Vadim", "Dytyniak");
		System.out.println(ss.getAll());

		ss.setGroup("Vadim", "Dytyniak", "KH-34");

		System.out.println(gs.getAll());
	}

}
