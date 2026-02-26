package com.lucas.dto;

import com.lucas.model.Prioridade;
import com.lucas.model.Responsavel;

public class TarefaFiltroDto {
	
	private Long id;
	private String titulo;
	private Responsavel responsavel;
	private Prioridade prioridade;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Responsavel getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	public Prioridade getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
	

}
