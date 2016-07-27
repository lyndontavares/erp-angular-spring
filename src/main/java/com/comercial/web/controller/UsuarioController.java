package com.comercial.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.autenticacao.Usuario;
import com.comercial.model.repository.UsuarioRepository;
import com.comercial.model.service.UsuarioService;
import com.comercial.model.service.filtros.UsuarioFiltro;

@RestController
@RequestMapping("/api")
public class UsuarioController
{

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private UsuarioService repoFiltro;

    @RequestMapping(value = "/usuario/filtro", method = RequestMethod.POST)
    public List<Usuario> listaFiltro(@RequestBody UsuarioFiltro filtros)
    {
        return repoFiltro.consultar(filtros.getFiltros());
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public Iterable<Usuario> litaTodas()
    {
        return repo.findAll();
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario adicionar(@RequestBody final Usuario usuario)
    {
        Usuario p = repo.save(usuario);
        return p;
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable final long id)
    {
        repo.delete(id);
    }
    
    @RequestMapping(value = "/usuario/total", method = RequestMethod.GET)
    public long count()
    {
        return repo.count();
    }
}
