package com.example.erp.controller;

import com.example.erp.model.RamoAtividade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;

public class RamoAtividadeConverter implements Converter {
    private List<RamoAtividade> listaRamoAtividades;

    public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividades) {
        this.listaRamoAtividades = listaRamoAtividades;
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null){
            return null;
        }
        Long id = Long.valueOf(value);
        for(RamoAtividade ramoAtividade : listaRamoAtividades){
            if(id.equals(ramoAtividade.getId())){
                return ramoAtividade;
            }
        }
        return null;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null)
            return null;

        RamoAtividade ramoAtividade = (RamoAtividade) value;
        return ramoAtividade.getId().toString();
    }
}