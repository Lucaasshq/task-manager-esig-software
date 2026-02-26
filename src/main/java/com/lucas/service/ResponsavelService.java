package com.lucas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.lucas.model.Responsavel;
import com.lucas.repository.ResponsavelRepository;

public class ResponsavelService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResponsavelRepository responsavelRepository;
	
	public List<Responsavel> listarTodos(){
		return responsavelRepository.findAll();
	}
	
	public Responsavel buscarPorId(Long id) {
		return responsavelRepository.findById(id);
	}
	
	public void salvar(Responsavel responsavel) {
		responsavelRepository.save(responsavel);
	}
	
	public void excluir(Responsavel responsavel) {
		responsavelRepository.delete(responsavel);
	}
	
	

}
