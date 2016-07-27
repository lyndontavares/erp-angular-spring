package com.comercial.model.aprovacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GrupoAprovacao
{
    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable=false,length=100,unique=true)
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
    
    
    

}
