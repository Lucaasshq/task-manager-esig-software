package com.lucas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.lucas.model.Responsavel;
import com.lucas.utils.Transactional;

public class ResponsavelRepository {

	@Inject
	private EntityManager em;

	public ResponsavelRepository() {

	}

	public ResponsavelRepository(EntityManager em) {
		this.em = em;
	}

	public List<Responsavel> findAll() {
		return em.createQuery("select r from Responsavel r", Responsavel.class).getResultList();
	}

	public Responsavel findById(Long id) {
		return em.find(Responsavel.class, id);
	}
	
	@Transactional
	public void save(Responsavel responsavel) {
		System.out.println(responsavel.toString());
		if (responsavel.getId() == null) {
			em.persist(responsavel);
			return;
		} else {
			em.merge(responsavel);
		}

	}
	@Transactional
	public void delete(Responsavel responsavel) {
		responsavel = findById(responsavel.getId());
		em.remove(responsavel);
	}
}
