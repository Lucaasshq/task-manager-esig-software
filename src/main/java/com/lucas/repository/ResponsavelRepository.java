package com.lucas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.lucas.model.Responsavel;

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

	public void save(Responsavel responsavel) {
		if (responsavel.getId() == null) {
			em.persist(responsavel);
			return;
		} else {
			em.merge(responsavel);
		}

	}

	public void delete(Responsavel responsavel) {
		responsavel = findById(responsavel.getId());
		em.remove(responsavel);
	}
}
