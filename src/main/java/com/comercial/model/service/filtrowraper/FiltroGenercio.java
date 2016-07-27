package com.comercial.model.service.filtrowraper;

import java.util.List;

public interface FiltroGenercio<T>
{

    public List<T> consultar(List<Filtro> filtros);
    
}
