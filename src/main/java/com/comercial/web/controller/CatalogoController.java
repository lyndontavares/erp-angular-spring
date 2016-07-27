package com.comercial.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.commons.Catalogo;
import com.comercial.model.repository.CatalogoRepository;
import com.comercial.model.service.CatalogoService;
import com.comercial.model.service.filtros.CatalogoFiltro;

@RestController
@RequestMapping("/api")
public class CatalogoController
{

    @Autowired
    private CatalogoRepository repo;

    @Autowired
    private CatalogoService repoFiltro;

    @RequestMapping(value = "/catalogo/filtro", method = RequestMethod.POST)
    public List<Catalogo> listaFiltro(@RequestBody CatalogoFiltro filtros)
    {
        return repoFiltro.consultar(filtros.getFiltros());
    }

    @RequestMapping(value = "/catalogo", method = RequestMethod.GET)
    public Iterable<Catalogo> litaTodas()
    {
        return repo.findAll();
    }

    @RequestMapping(value = "/catalogo", method = RequestMethod.POST)
    public Catalogo adicionar(@RequestBody final Catalogo catalogo)
    {
        Catalogo c = repo.save(catalogo);
        return c;
    }

    @RequestMapping(value = "/catalogo/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable final long id)
    {
        repo.delete(id);
    }

    @RequestMapping(value = "/catalogo/total", method = RequestMethod.GET)
    public long count()
    {
        return repo.count();
    }
}
