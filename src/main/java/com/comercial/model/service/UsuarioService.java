package com.comercial.model.service;

import org.springframework.stereotype.Service;

import com.comercial.model.autenticacao.Usuario;
import com.comercial.model.service.filtrowraper.FiltroServiceGenerico;

@Service
public class UsuarioService extends FiltroServiceGenerico<Usuario>
{
    public UsuarioService() {
        super(Usuario.class);
    }
}
