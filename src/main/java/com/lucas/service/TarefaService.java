package com.lucas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.lucas.dto.TarefaFiltroDto;
import com.lucas.model.Status;
import com.lucas.model.Tarefa;
import com.lucas.repository.TarefaRepository;
import com.lucas.utils.Transactional;

public class TarefaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TarefaRepository tarefaRepository;

	public List<Tarefa> listarTodas() {
		return tarefaRepository.findAll();
	}

	public Tarefa buscarPorId(Long id) {
		return tarefaRepository.findById(id);
	}
	
	@Transactional
	public void salvar(Tarefa tarefa) {
		tarefa.setStatus(Status.EM_ANDAMENTO);
		tarefaRepository.save(tarefa);
	}
	
	@Transactional
	public void editar(Tarefa tarefa) {
		tarefaRepository.editar(tarefa);
	}
	
	@Transactional
	public void excluir(Tarefa tarefa) {
		tarefaRepository.delete(tarefa);
	}
	
	public List<Tarefa> pesquisar(TarefaFiltroDto filtro) {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(filtro.getId());
		tarefa.setTitulo(filtro.getTitulo());
		tarefa.setResponsavel(filtro.getResponsavel());
		tarefa.setPrioridade(filtro.getPrioridade());
		return tarefaRepository.pesquisar(tarefa);
	}

}
