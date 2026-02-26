package com.lucas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "responsavel")
public class Responsavel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatorio")
	@Size(min = 3, max = 100, message = "O nome deve conter entre 3 e 100 caracteres")
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "data_nascimento", nullable = false)
	@NotNull(message = "A data de nascimento é obrigatória")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	
	@Column(name = "data_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsavel other = (Responsavel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Responsavel [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", dataCadastro="
				+ dataCadastro + "]";
	}


}