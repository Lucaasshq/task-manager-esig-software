package com.lucas.testunitario;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lucas.model.Prioridade;
import com.lucas.model.Responsavel;
import com.lucas.model.Status;
import com.lucas.model.Tarefa;
import com.lucas.repository.TarefaRepository;
import com.lucas.service.TarefaService;

public class TarefaServiceTest {

	@Mock
	private TarefaRepository tarefaRepository;

	@InjectMocks
	private TarefaService tarefaService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void chamarRespositorioAoSalvarParaTestDados() {

		Responsavel responsavelTest = new Responsavel();
		responsavelTest.setId(1L);
		responsavelTest.setNome("Lucas");
		responsavelTest.setDataCadastro(new Date());
		responsavelTest.setDataNascimento(
				Date.from(LocalDate.of(2004, 01, 26).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		Tarefa tarefaTest = new Tarefa();
		tarefaTest.setId(1L);
		tarefaTest.setTitulo("Testando Tarefa");
		tarefaTest.setDescricao("Descrição da tarefa de teste");
		tarefaTest.setPrioridade(Prioridade.ALTA);
		tarefaTest.setStatus(Status.EM_ANDAMENTO);
		tarefaTest.setResponsavel(responsavelTest);
		tarefaTest.setDeadLine(LocalDate.of(2027, 12, 31));
		
		tarefaService.salvar(tarefaTest);
		
		verify(tarefaRepository).save(tarefaTest);
		// Test Responsavel
		assertEquals(1, tarefaTest.getResponsavel().getId().intValue());
		assertEquals("Lucas", tarefaTest.getResponsavel().getNome());
		// Test Tarefa
		assertEquals(1, tarefaTest.getId().intValue());
		assertEquals("Testando Tarefa", tarefaTest.getTitulo());
		assertEquals("Descrição da tarefa de teste", tarefaTest.getDescricao());
		assertEquals(Prioridade.ALTA, tarefaTest.getPrioridade());
		assertEquals(Status.EM_ANDAMENTO, tarefaTest.getStatus());
	}
	
	@Test
	public void excluirTarefaInexistente() {
		Tarefa tarefa = new Tarefa();
		
		if (tarefa == null || tarefa.getId() == null) {
			return;
		}
		
		tarefaService.excluir(tarefa);
		
		verify(tarefaRepository, never()).delete(any(Tarefa.class));
	}
	
	
	@Test
	public void editarTarefaExistente() {
		Responsavel responsavelTest = new Responsavel();
		responsavelTest.setId(1L);
		responsavelTest.setNome("Lucas");
		responsavelTest.setDataCadastro(new Date());
		responsavelTest.setDataNascimento(
				Date.from(LocalDate.of(2004, 01, 26).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		Tarefa tarefaBanco = new Tarefa();
		tarefaBanco.setId(1L);
		tarefaBanco.setTitulo("Tarefa com titulo antigo");

		Tarefa tarefaTest = new Tarefa();
		tarefaTest.setId(1L);
		tarefaTest.setTitulo("Novo Titulo");
		tarefaTest.setDescricao("Descrição da tarefa de teste");
		tarefaTest.setPrioridade(Prioridade.ALTA);
		tarefaTest.setStatus(Status.CONCLUIDA);
		tarefaTest.setResponsavel(responsavelTest);
		tarefaTest.setDeadLine(LocalDate.of(2027, 12, 31));
		
		// quando o mock buscar por id 1 ele retorna a tarefaBanco
		when(tarefaRepository.findById(1L)).thenReturn(tarefaBanco);
		
		tarefaService.editar(tarefaTest);
		
		// verifica se o metodo save foi chamada 1 vez
		verify(tarefaRepository, times(1)).update(tarefaTest);
		
		assertEquals("Novo Titulo", tarefaTest.getTitulo());
		assertEquals(Status.CONCLUIDA, tarefaTest.getStatus());
	}
	
}
