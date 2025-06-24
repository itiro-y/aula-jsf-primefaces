package com.example.erp.controller;

import com.example.erp.model.Empresa;
import com.example.erp.repository.Empresas;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("gestaoEmpresasBean")
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Empresa> listaEmpresas;

    @Inject
    private Empresas empresas;

    public void todasEmpresas(){
        listaEmpresas = empresas.todas();
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
}
