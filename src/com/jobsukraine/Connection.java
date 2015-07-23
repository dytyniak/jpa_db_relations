package com.jobsukraine;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	private EntityManager em;
	private boolean connectionEstablished;
	private boolean log;

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
	
	private static Map<String, String> getCustomProperties(String user, String password, String url, String dbName, boolean log) {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://" + url + "/" + dbName);
		properties.put("javax.persistence.jdbc.user", user);
		properties.put("javax.persistence.jdbc.password", password);
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		if (log){
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
		} else {
			properties.put("hibernate.show_sql", "false");
			properties.put("hibernate.format_sql", "false");
		}
		return properties;
	}

	public Connection(String user, String password, String url, String dbName, boolean log) {
		try {
			this.log = log;
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_db_relations",
					getCustomProperties(user, password, url, dbName, log));
			this.em = emf.createEntityManager();
			
			connectionEstablished = true;
		} catch (Exception e) {
			connectionEstablished = false;
		}
	}
	
	public Connection(String user, String password, String url, String dbName) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_db_relations",
					getCustomProperties(user, password, url, dbName));
			this.em = emf.createEntityManager();
			
			this.log = true;
			
			connectionEstablished = true;
		} catch (Exception e) {
			if (log)
				e.printStackTrace();
			connectionEstablished = false;
		}
	}


	public EntityManager getManager() {
		return em;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	public boolean isConnected() {
		return connectionEstablished;
	}
}
