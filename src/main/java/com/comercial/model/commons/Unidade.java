package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Unidade
{
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String descricao;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Unidade()
    {
    };

    public Unidade(long id, String descricao)
    {
        super();
        this.id = id;
        this.descricao = descricao;
    }

    public Unidade(long id)
    {
        super();
        this.id = id;
    }

}
