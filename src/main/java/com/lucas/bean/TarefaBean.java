package com.lucas.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucas.dto.TarefaFiltroDto;
import com.lucas.model.Prioridade;
import com.lucas.model.Responsavel;
import com.lucas.model.Status;
import com.lucas.model.Tarefa;
import com.lucas.service.ResponsavelService;
import com.lucas.service.TarefaService;
import com.lucas.utils.Message;

@Named
@ViewScoped
public class TarefaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private TarefaService tarefaService;
	
	@Inject
	private ResponsavelService responsavelService;
	
	private Tarefa tarefa;
	
	private List<Responsavel> responsaveis;
	
	private List<Tarefa> tarefas;
	
	private TarefaFiltroDto filtroTarefas;
	
	@PostConstruct
	public void init() {
		tarefa = new Tarefa();
		filtroTarefas = new TarefaFiltroDto();
	    responsaveis = responsavelService.listarTodos();
	    tarefas = tarefaService.listarTodas();
	    
	}
	
	public void filtrar() {
		tarefas = tarefaService.pesquisar(filtroTarefas);
	}
	
	public void limparFiltro() {
		filtroTarefas = new TarefaFiltroDto();
		tarefas = tarefaService.listarTodas();
	}
	
	public void salvarTarefa() {
		try {
	        tarefaService.salvar(tarefa);
	        Message.addMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Tarefa salva com sucesso!");
	        tarefa = new Tarefa(); 
	        
	    } catch (Exception e) {
	    	Message.addMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public void editarTarefa() {
		try {
			tarefaService.editar(tarefa);
			Message.addMessage(FacesMessage.SEVERITY_INFO, "Tarefa Editada com Sucesso", null);
			tarefa = new Tarefa(); 

		} catch (Exception e) {
			Message.addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Editar Tarefa", null);
		}
	}
	
	public void prepararEdicao(Tarefa tarefaSelecionada) {
		this.tarefa = tarefaSelecionada;
	}
	
	
	public void deletarTarefa(Tarefa tarefa) {
		
		try {
			tarefaService.excluir(tarefa);
			tarefas.remove(tarefa);
		} catch (Exception e) {
			System.out.println("Erro ao excluir tarefa: " + e.getMessage());
		}
	}
	
	
	public TarefaFiltroDto getFiltroTarefas() {
		return filtroTarefas;
	}

	public void setFiltroTarefas(TarefaFiltroDto filtroTarefas) {
		this.filtroTarefas = filtroTarefas;
	}

	public List<Tarefa> getlistaTarefas() {
		return tarefas;
	}
	
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}
	
	

	public Prioridade[] getPrioridades() {
		return Prioridade.values();
	}
	
	public Status[] getStatus() {
		return Status.values();
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	
	
	
	

}
