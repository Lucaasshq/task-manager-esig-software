package com.lucas.service;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import com.lucas.model.Responsavel;
import com.lucas.repository.ResponsavelRepository;
import com.lucas.utils.Transactional;

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
	
	@Transactional
	public void salvar(Responsavel responsavel) {
		responsavel.setDataCadastro(Date.valueOf(LocalDate.now()));
		responsavelRepository.save(responsavel);
	}
	@Transactional
	public void excluir(Responsavel responsavel) {
		responsavelRepository.delete(responsavel);
	}
	
	

}
