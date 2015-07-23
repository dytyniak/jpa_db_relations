package com.jobsukraine.onetomany.unidirectional.manytoone;

import java.util.List;

import javax.persistence.EntityManager;

import com.jobsukraine.Connection;

public class Main {

	public static void main(String[] args) {
		Connection connection = new Connection("root", "admin", "192.168.1.107", "relations");
		EntityManager em = connection.getManager();
	}

	
}
