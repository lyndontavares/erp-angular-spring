package com.comercial.model.financeiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.comercial.model.commons.Filial;

@Entity
public class Caixa
{

    @Id
    @GeneratedValue
    private long id;
    
    private String nome;
    
    @ManyToOne
    private Filial filial;

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

    public Filial getFilial()
    {
        return filial;
    }

    public void setFilial(Filial filial)
    {
        this.filial = filial;
    }
 
}
