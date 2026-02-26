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
		Map<String, String> props = new HashMap<>();
	    
	    // Pegamos as variáveis brutas do Railway
	    String host = System.getenv("PGHOST");
	    String port = System.getenv("PGPORT");
	    String db   = System.getenv("PGDATABASE");
	    String user = System.getenv("PGUSER");
	    String pass = System.getenv("PGPASSWORD");

	    // Montamos a URL JDBC manualmente no Java
	    String url = String.format("jdbc:postgresql://%s:%s/%s", host, port, db);

	    props.put("javax.persistence.jdbc.url", url);
	    props.put("javax.persistence.jdbc.user", user);
	    props.put("javax.persistence.jdbc.password", pass);
	    props.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");

	    // Garante que o Hibernate use o dialeto correto
	    props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

		this.emf = Persistence.createEntityManagerFactory("TarefasPU", props);
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
