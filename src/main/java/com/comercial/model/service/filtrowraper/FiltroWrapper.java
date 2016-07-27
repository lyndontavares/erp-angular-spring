package com.comercial.model.service.filtrowraper;

import java.util.List;

public abstract class FiltroWrapper
{

    protected List<Filtro> filtros;

    public List<Filtro> getFiltros()
    {
        return filtros;
    }

    public void setFiltros(List<Filtro> filtros)
    {

        this.filtros = filtros;
    }

    @Override
    public String toString()
    {
        return "FiltroWrapper [filtros=" + filtros + "]";
    }

}
