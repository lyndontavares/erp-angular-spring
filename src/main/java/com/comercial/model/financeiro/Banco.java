package com.comercial.model.financeiro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Banco
{

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false, length = 100)
    private String nome;

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

    public Banco()
    {
    };

    public Banco(long id, String nome)
    {
        super();
        this.id = id;
        this.nome = nome;
    }

}
