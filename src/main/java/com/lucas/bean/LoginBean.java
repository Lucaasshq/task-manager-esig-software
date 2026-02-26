package com.lucas.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String senha;
	private boolean logado = false;
	
	public String login() {
		if ("admin".equals(nome) && "123456".equals(senha)) {
			logado = true;
			return "tarefa?faces-redirect=true";
		} else {
			logado = false;
			return "login?faces-redirect=true";
		}
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
	

}
