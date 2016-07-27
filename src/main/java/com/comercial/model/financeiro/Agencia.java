package com.comercial.model.financeiro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agencia
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Banco banco;

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

    public Banco getBanco()
    {
        return banco;
    }

    public void setBanco(Banco banco)
    {
        this.banco = banco;
    }

    public Agencia()
    {
    };

    public Agencia(long id, Banco banco, String nome)
    {
        super();
        this.id = id;
        this.banco = banco;
        this.nome = nome;
    }

}
