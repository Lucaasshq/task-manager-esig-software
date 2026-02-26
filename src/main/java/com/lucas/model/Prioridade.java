package com.lucas.model;

public enum Prioridade {

	BAIXA("Baixa"),
	MEDIA("Média"),
	ALTA("Alta");

	private String descricao;

	Prioridade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}