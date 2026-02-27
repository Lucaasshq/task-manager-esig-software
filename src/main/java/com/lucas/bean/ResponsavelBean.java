package com.lucas.bean;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucas.model.Responsavel;
import com.lucas.service.ResponsavelService;
import com.lucas.utils.Message;

@Named
@ViewScoped
public class ResponsavelBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ResponsavelService responsavelService;
	
	private Responsavel responsavel;
	
	@PostConstruct
	public void init() {
		responsavel = new Responsavel();
	}
	
	public void salvarResponsavel() {
		try {
			
			responsavelService.salvar(responsavel);
			Message.addMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Responsável salvo com sucesso!");
			responsavel = new Responsavel();
		} catch (Exception e) {
			Message.addMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar Responsável: " + e.getMessage());
			responsavel = new Responsavel();
		}
		
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	
	
	

}
