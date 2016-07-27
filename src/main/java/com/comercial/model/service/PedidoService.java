package com.comercial.model.service;

import org.springframework.stereotype.Service;

import com.comercial.model.commons.Pedido;
import com.comercial.model.service.filtrowraper.FiltroServiceGenerico;

@Service
public class PedidoService extends FiltroServiceGenerico<Pedido>
{
    public PedidoService() {
        super(Pedido.class);
    }
}
