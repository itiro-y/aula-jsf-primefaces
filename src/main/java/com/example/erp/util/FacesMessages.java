package com.example.erp.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class FacesMessages implements Serializable {
    private static final long serialVersionUID = 1L;

    private void add(String msg, FacesMessage.Severity severity){
        FacesMessage facesMessage = new FacesMessage(msg);
        facesMessage.setSeverity(severity);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public void info(String msg){
        add(msg, FacesMessage.SEVERITY_INFO);
    }
}
