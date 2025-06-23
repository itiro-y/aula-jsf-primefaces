package com.example.erp.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Integer NUMERO = 0;

    public GestaoEmpresasBean() {
        NUMERO++;
    }

    public Integer getNUMERO() {
        return NUMERO;
    }


}
