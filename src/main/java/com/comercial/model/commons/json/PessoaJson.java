package com.comercial.model.commons.json;

import java.util.ArrayList;
import java.util.List;

import com.comercial.model.commons.Pessoa;
import com.comercial.model.service.filtrowraper.Filtro;

public class PessoaJson
{

    private Pessoa pessoa;

    private List<Filtro> filtro;

    public Pessoa getPessoa()
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }

    public List<Filtro> getFiltro()
    {
        return filtro;
    }

    public void setFiltro(List<Filtro> filtro)
    {
        this.filtro = filtro;
    }

    public PessoaJson()
    {
    }

    public static class Builder
    {
        PessoaJson built;

        Builder()
        {
        }

        public PessoaJson build()
        {
            built = new PessoaJson();
            built.pessoa = new Pessoa();
            built.filtro = new ArrayList<>();

            return built;
        }
    }

}
