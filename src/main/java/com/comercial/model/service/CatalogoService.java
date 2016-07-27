package com.comercial.model.service;

import org.springframework.stereotype.Service;

import com.comercial.model.commons.Catalogo;
import com.comercial.model.service.filtrowraper.FiltroServiceGenerico;

@Service
public class CatalogoService extends FiltroServiceGenerico<Catalogo>
{
    public CatalogoService() {
        super(Catalogo.class);
    }
}
