package com.comercial.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.json.PessoaJson;
import com.comercial.model.repository.PessoaRepository;
import com.comercial.model.service.filtrowraper.FiltroServiceGenerico;

@Service
public class PessoaService extends FiltroServiceGenerico<Pessoa>
{
    public PessoaService()
    {
        super(Pessoa.class);
    }

    @Autowired
    PessoaRepository pessoaRepository;
 
    public Pessoa save(Pessoa pessoa)
    {
        return pessoaRepository.save(pessoa);
    }

    public Iterable<Pessoa> findAll()
    {
        return pessoaRepository.findAll();
    }

    public Long count()
    {
        return pessoaRepository.count();
    }

    public void delete(long id)
    {
        pessoaRepository.delete(id);
    }
    
    public PessoaJson pegarModelo(){
        return new PessoaJson();
    }
    
}
