package com.example.erp.service;

import com.example.erp.model.Empresa;
import com.example.erp.repository.Empresas;
import com.example.erp.util.Transacional;

import java.io.Serializable;

import javax.inject.Inject;


public class CadastroEmpresaService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    @Transacional
    public void salvar(Empresa empresa) {
        empresas.guardar(empresa);
    }

    @Transacional
    public void excluir(Empresa empresa) {
        empresas.remover(empresa);
    }

}