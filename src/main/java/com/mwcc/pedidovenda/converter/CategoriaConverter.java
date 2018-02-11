package com.mwcc.pedidovenda.converter;

import com.mwcc.pedidovenda.model.Categoria;
import com.mwcc.pedidovenda.repository.Categorias;
import com.mwcc.pedidovenda.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter{

    //@Inject
    private Categorias categorias;

    public CategoriaConverter(){
        categorias = CDIServiceLocator.getBean(Categorias.class);
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Categoria retorno = null;

        if (s != null){
            Long id = new Long(s);
            retorno = categorias.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o != null){
            return ((Categoria) o).getId().toString();
        }

        return "";
    }
}
