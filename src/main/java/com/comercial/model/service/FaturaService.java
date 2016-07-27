package com.comercial.model.service;

import org.springframework.stereotype.Service;

import com.comercial.model.commons.Pessoa;
import com.comercial.model.service.filtrowraper.FiltroServiceGenerico;

@Service
public class FaturaService extends FiltroServiceGenerico<Pessoa>
{
    public FaturaService() {
        super(Pessoa.class);
    }
}
