package com.lucas.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lucas.model.Status;
import com.lucas.model.Tarefa;
import com.lucas.utils.Transactional;


public class TarefaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private EntityManager em;
	
	public TarefaRepository() {
		
	}
	
	public TarefaRepository(EntityManager em) {
		this.em = em;
	}
	
	
	public List<Tarefa> findAll(){
		return em.createQuery("select t from Tarefa t", Tarefa.class).getResultList();
	}
	
	public Tarefa findById(Long id) {
		return em.find(Tarefa.class, id);
	}
	
	public List<Tarefa> findAllAtivas(){
		return em.createQuery("select t from Tarefa t where t.status <> :statusConcluido", Tarefa.class)
				.setParameter("statusConcluido", Status.CONCLUIDA)
				.getResultList();
	}
	
	@Transactional
	public void save(Tarefa tarefa) {
		if (tarefa.getId() == null) {
			em.persist(tarefa);
			return;
		} else {
			em.merge(tarefa);
		}
	}
	
	@Transactional
	public void update(Tarefa tarefa) {
			em.merge(tarefa);
	}
	
	
	@Transactional
	public void delete(Tarefa tarefa) {
		tarefa = findById(tarefa.getId());
		em.remove(tarefa);
	}
	
	public List<Tarefa> search(Tarefa filtro) {
		
		StringBuilder jpql = new StringBuilder("select t from Tarefa t where t.status <> :statusConcluido ");
		
		
		
		if (filtro.getId() != null) {
			jpql.append("and t.id = :id ");
		}

		
		if (filtro.getTitulo() != null && !filtro.getTitulo().isEmpty()) {
			jpql.append("and lower(t.titulo) like lower(:titulo) ");
		}

		
		if (filtro.getResponsavel() != null) {
			jpql.append("and t.responsavel = :responsavel ");
		}

		
		if (filtro.getPrioridade() != null) {
			jpql.append("and t.prioridade = :prioridade ");
		}

		
		TypedQuery<Tarefa> query = em.createQuery(jpql.toString(), Tarefa.class);
		
		
		query.setParameter("statusConcluido", Status.CONCLUIDA);
		
		
		if(filtro.getId() != null) {
			query.setParameter("id", filtro.getId());
		}

		if (filtro.getTitulo() != null && !filtro.getTitulo().isEmpty()) {
			query.setParameter("titulo", "%" + filtro.getTitulo() + "%");
		}

		if (filtro.getResponsavel() != null) {
			query.setParameter("responsavel", filtro.getResponsavel());
		}

		if (filtro.getPrioridade() != null) {
			query.setParameter("prioridade", filtro.getPrioridade());
		}

		return query.getResultList();
	}
	

}
