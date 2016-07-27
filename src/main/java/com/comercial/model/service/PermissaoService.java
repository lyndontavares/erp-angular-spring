package com.comercial.model.service;

import org.springframework.stereotype.Service;

import com.comercial.model.autenticacao.Permissao;
import com.comercial.model.service.filtrowraper.FiltroServiceGenerico;

@Service
public class PermissaoService extends FiltroServiceGenerico<Permissao>
{
    public PermissaoService() {
        super(Permissao.class);
    }
}
