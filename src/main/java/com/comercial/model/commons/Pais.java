package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.comercial.model.commons.enums.Moeda;

@Entity
public class Pais
{
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false, length = 100)
    private String nome;

    private String sigla;

    @Column(unique = true)
    private long ddi;

    @Enumerated(EnumType.STRING)
    private Moeda moeda;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public long getDdi()
    {
        return ddi;
    }

    public void setDdi(long ddi)
    {
        this.ddi = ddi;
    }

    public Moeda getMoeda()
    {
        return moeda;
    }

    public void setMoeda(Moeda moeda)
    {
        this.moeda = moeda;
    }

    public String getSigla()
    {
        return sigla;
    }

    public void setSigla(String sigla)
    {
        this.sigla = sigla;
    }

    public Pais(long id, String nome, String sigla, long ddi, Moeda moeda)
    {
        super();
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.ddi = ddi;
        this.moeda = moeda;
    }

    public Pais()
    {
    }
}
