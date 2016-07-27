package com.comercial.model.commons;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Empresa
{
    
    private String nome;
    
    private String endereco;
    
    private String telefone;
    
    private String email;
    
    private String codigoContribuinte;

    @ManyToOne
    Pais pais;

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCodigoContribuinte()
    {
        return codigoContribuinte;
    }

    public void setCodigoContribuinte(String codigoContribuinte)
    {
        this.codigoContribuinte = codigoContribuinte;
    }

    public Empresa(String nome, String endereco, String telefone, String email, String codigoContribuinte)
    {
        super();
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.codigoContribuinte = codigoContribuinte;
    }

    public Empresa(){}

    public Pais getPais()
    {
        return pais;
    }

    public void setPais(Pais pais)
    {
        this.pais = pais;
    }
    
}
