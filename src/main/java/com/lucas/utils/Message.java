package com.lucas.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Message {

	public static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

}
