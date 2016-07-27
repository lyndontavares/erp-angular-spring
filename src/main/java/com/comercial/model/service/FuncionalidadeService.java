package com.comercial.model.service;

import org.springframework.stereotype.Service;

import com.comercial.model.autenticacao.Funcionalidade;
import com.comercial.model.service.filtrowraper.FiltroServiceGenerico;

@Service
public class FuncionalidadeService extends FiltroServiceGenerico<Funcionalidade>
{
    public FuncionalidadeService() {
        super(Funcionalidade.class);
    }
}
