package com.comercial.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.commons.Fatura;
import com.comercial.model.commons.Pessoa;
import com.comercial.model.repository.FaturaRepository;
import com.comercial.model.service.FaturaService;
import com.comercial.model.service.filtros.FaturaFiltro;

@RestController
@RequestMapping("/api")
public class FaturaController
{

    @Autowired
    private FaturaRepository repo;

    @Autowired
    private FaturaService repoFiltro;

    @RequestMapping(value = "/fatura/filtro", method = RequestMethod.POST)
    public List<Pessoa> listaFiltro(@RequestBody FaturaFiltro filtros)
    {
        return repoFiltro.consultar(filtros.getFiltros());
    }

    @RequestMapping(value = "/fatura", method = RequestMethod.GET)
    public Iterable<Fatura> litaTodas()
    {
        return repo.findAll();
    }

    @RequestMapping(value = "/fatura", method = RequestMethod.POST)
    public Fatura adicionar(@RequestBody final Fatura fatura)
    {
        Fatura fat = repo.save(fatura);
        return fat;
    }

    @RequestMapping(value = "/fatura/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable final long id)
    {
        repo.delete(id);
    }

    @RequestMapping(value = "/fatura/total", method = RequestMethod.GET)
    public long count()
    {
        return repo.count();
    }
}
