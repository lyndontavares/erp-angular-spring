package com.comercial.web.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.infra.agendador.TarefaService;
import com.comercial.model.autenticacao.views.View;
import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.Role;
import com.comercial.model.commons.json.PessoaJson;
import com.comercial.model.repository.RoleRepository;
import com.comercial.model.service.PessoaService;
import com.comercial.model.service.filtros.PessoaFiltro;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api")
public class PessoaController
{

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private RoleRepository repoRole;

    @Autowired
    TarefaService tarefaService;

    @RequestMapping(value = "/pessoa/model", method = RequestMethod.GET)
    public PessoaJson pegarModelo()
    {
        return pessoaService.pegarModelo();
    }

    @JsonView(View.class)
    @RequestMapping(value = "/pessoa/filtro", method = RequestMethod.POST)
    public List<Pessoa> listaFiltro(@RequestBody PessoaFiltro filtros)
    {
        return pessoaService.consultar(filtros.getFiltros());
    }

    @JsonView(View.class)
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public Iterable<Pessoa> litaTodas()
    {
        return pessoaService.findAll();
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    @Transactional
    public Pessoa adicionar(@RequestBody final Pessoa pessoa)
    {

        return SalvarPessoa(pessoa);
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.PUT)
    @Transactional
    public Pessoa update(@RequestBody final Pessoa pessoa)
    {
        return SalvarPessoa(pessoa);
    }

   
    private Pessoa SalvarPessoa(final Pessoa pessoa)
    {
        Pessoa newPessoa = pessoaService.save(pessoa);

        if (pessoa.getRoles() != null)
        {

            repoRole.deleteByPessoa(pessoa);

            for (Role role : pessoa.getRoles())
            {

                role.setId(0);
                role.setPessoa(newPessoa);
                repoRole.save(role);

            }
        }

        return newPessoa;
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable final long id)
    {
        pessoaService.delete(id);
    }

    @RequestMapping(value = "/pessoa/total", method = RequestMethod.GET)
    public long count()
    {
        return pessoaService.count();
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public void emailTeste()
    {
        tarefaService.enviarEmailExemplo();
    }

    @RequestMapping(value = "/emailssh", method = RequestMethod.GET)
    public void emailSSH()
    {
        tarefaService.enviarEmailSSH();
    }

    @RequestMapping(value = "/emailtsl", method = RequestMethod.GET)
    public void emailTSL()
    {
        tarefaService.enviarEmailTLS();
    }

}
