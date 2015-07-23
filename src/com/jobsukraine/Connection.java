package com.jobsukraine;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	private EntityManager em;
	private boolean connectionEstablished;

	private static Map<String, String> getCustomProperties(String user, String password, String url, String dbName) {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://" + url + "/" + dbName);
		properties.put("javax.persistence.jdbc.user", user);
		properties.put("javax.persistence.jdbc.password", password);
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	public Connection(String user, String password, String url, String dbName) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_db_relations",
					getCustomProperties(user, password, url, dbName));
			this.em = emf.createEntityManager();
			
			connectionEstablished = true;
		} catch (Exception e) {
			connectionEstablished = false;
		}
	}

	public EntityManager getManager() {
		return em;
	}

	public boolean isConnected() {
		return connectionEstablished;
	}

	public static void main(String[] args) {
		Connection conn = new Connection("root", "admin", "localhost", "testdb");
		System.out.println(conn.isConnected());
	}
}
