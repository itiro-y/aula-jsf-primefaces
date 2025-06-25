package com.example.erp.controller;

import com.example.erp.model.Empresa;
import com.example.erp.model.RamoAtividade;
import com.example.erp.model.TipoEmpresa;
import com.example.erp.repository.Empresas;
import com.example.erp.repository.RamoAtividades;
import com.example.erp.service.CadastroEmpresaService;
import com.example.erp.util.FacesMessages;
import org.jboss.weld.context.RequestContext;
import org.primefaces.PrimeFaces;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;



@Named("gestaoEmpresasBean")
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Empresa> listaEmpresas;
    private String termoPesquisa;
    private RamoAtividadeConverter ramoAtividadeConverter;

    @Inject
    private CadastroEmpresaService cadastroEmpresaService;

    @Inject
    private RamoAtividades ramoAtividade;

    @Inject
    private FacesMessages messages;

    @Inject
    private Empresas empresas;

    private Empresa empresa;

    public void prepararNovaEmpresa(){
        empresa = new Empresa();
    }

    public void salvar(){
        cadastroEmpresaService.salvar(empresa);

        atualizarRegistros();
        messages.info("Empresa salva com sucesso!");
        PrimeFaces.current().ajax().update(Arrays.asList("frm:empresasDataTable", "frm:messages"));
    }

    public void excluir(){
        cadastroEmpresaService.excluir(empresa);
        empresa = null;

        atualizarRegistros();
        messages.info("Empresa excluida com sucesso!");
    }

    private void atualizarRegistros(){
        if(jaHouvePesquisa()){
            pesquisar();
        } else{
            todasEmpresas();
        }
    }

    private boolean jaHouvePesquisa(){
        return termoPesquisa != null && !"".equals(termoPesquisa);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void todasEmpresas(){
        listaEmpresas = empresas.todas();
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public TipoEmpresa[] getTiposEmpresa(){
        return TipoEmpresa.values();
    }

    public void pesquisar(){
        listaEmpresas = empresas.pesquisar(termoPesquisa);
        if(listaEmpresas.isEmpty()){
            messages.info("Sua consulta não retornou registros");
        }
    }

    public List<RamoAtividade> completarRamoAtividade(String termo){
        List<RamoAtividade> listaRamoAtividades = ramoAtividade.pesquisar(termo);
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);

        return listaRamoAtividades;
    }

    public RamoAtividadeConverter getRamoAtividadeConverter() {
        return ramoAtividadeConverter;
    }

    public void setRamoAtividadeConverter(RamoAtividadeConverter ramoAtividadeConverter) {
        this.ramoAtividadeConverter = ramoAtividadeConverter;
    }

    public boolean isEmpresaSelecionada(){
        return empresa != null && empresa.getId() != null;
    }

    public void prepararEdicao(){
        ramoAtividadeConverter = new RamoAtividadeConverter(Arrays.asList(empresa.getRamoAtividade()));
    }


}
