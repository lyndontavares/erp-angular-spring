package com.comercial.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.autenticacao.Permissao;
import com.comercial.model.autenticacao.views.View;
import com.comercial.model.repository.PermissaoRepository;
import com.comercial.model.service.PermissaoService;
import com.comercial.model.service.filtros.PermissaoFiltro;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api")
public class PermissaoController
{

    @Autowired
    private PermissaoRepository repo;

    @Autowired
    private PermissaoService repoFiltro;

    @RequestMapping(value = "/permissao/filtro", method = RequestMethod.POST)
    public List<Permissao> listaFiltro(@RequestBody PermissaoFiltro filtros)
    {
        return repoFiltro.consultar(filtros.getFiltros());
    }
    
    @JsonView(View.class)
    @RequestMapping(value = "/permissao", method = RequestMethod.GET)
    public Iterable<Permissao> litaTodas()
    {
        return repo.findAll();
    }

    @RequestMapping(value = "/permissao", method = RequestMethod.POST)
    public Permissao adicionar(@RequestBody final Permissao usuario)
    {
        Permissao p = repo.save(usuario);
        return p;
    }

    @RequestMapping(value = "/permissao/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable final long id)
    {
        repo.delete(id);
    }
    
    @RequestMapping(value = "/permissao/total", method = RequestMethod.GET)
    public long count()
    {
        return repo.count();
    }
}
