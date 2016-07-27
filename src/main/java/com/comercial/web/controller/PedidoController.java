package com.comercial.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.commons.Pedido;
import com.comercial.model.repository.PedidoRepository;
import com.comercial.model.service.PedidoService;
import com.comercial.model.service.filtros.PedidoFiltro;

@RestController
@RequestMapping("/api")
public class PedidoController
{

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private PedidoService repoFiltro;

    @RequestMapping(value = "/pedido/filtro", method = RequestMethod.POST)
    public List<Pedido> listaFiltro(@RequestBody PedidoFiltro filtros)
    {
        return repoFiltro.consultar(filtros.getFiltros());
    }

    @RequestMapping(value = "/pedido", method = RequestMethod.GET)
    public Iterable<Pedido> litaTodas()
    {
        return repo.findAll();
    }

    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    public Pedido adicionar(@RequestBody final Pedido catalogo)
    {
        Pedido c = repo.save(catalogo);
        return c;
    }

    @RequestMapping(value = "/pedido/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable final long id)
    {
        repo.delete(id);
    }

    @RequestMapping(value = "/pedido/total", method = RequestMethod.GET)
    public long count()
    {
        return repo.count();
    }
}
