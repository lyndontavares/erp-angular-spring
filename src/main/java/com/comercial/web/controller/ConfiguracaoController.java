package com.comercial.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.commons.Configuracao;
import com.comercial.model.repository.ConfiguracaoRepository;

@RestController
@RequestMapping("/api")
public class ConfiguracaoController
{

    @Autowired
    private ConfiguracaoRepository repo;
 
    @RequestMapping(value = "/configuracao", method = RequestMethod.GET)
    public  Configuracao  consultar()
    {
        return repo.findAll().iterator().next();
    }

    @RequestMapping(value = "/configuracao", method = RequestMethod.PUT)
    public void update(@RequestBody final Configuracao configuracao)
    {
        repo.save(configuracao);
         
    }
 
}
