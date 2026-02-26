package com.lucas.utils;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProduce {
	
	private EntityManagerFactory emf;

	public EntityManagerProduce() {
		Map<String, String> properties = new HashMap<>();

		// Pega as variáveis que o Railway fornece automaticamente
		String host = System.getenv("PGHOST");
		String port = System.getenv("PGPORT");
		String dbName = System.getenv("PGDATABASE");
		String user = System.getenv("PGUSER");
		String password = System.getenv("PGPASSWORD");

		String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

		properties.put("javax.persistence.jdbc.url", url);
		properties.put("javax.persistence.jdbc.user", user);
		properties.put("javax.persistence.jdbc.password", password);
		this.emf = Persistence.createEntityManagerFactory("TarefasPU");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}

}
