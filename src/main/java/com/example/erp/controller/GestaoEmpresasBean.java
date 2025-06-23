package com.example.erp.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import com.example.erp.model.Empresa;
import com.example.erp.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Empresa empresa = new Empresa();

    public Empresa getEmpresa() {
        return empresa;
    }

    public TipoEmpresa[] getTiposEmpresa(){
        return TipoEmpresa.values();
    }

    public void salvar(){
        System.out.println("Razao social: " + empresa.getRazaoSocial()
                            + "Nome fantasia: " + empresa.getNomeFantasia()
                            + "Tipo: " + empresa.getTipo());
    }
}
