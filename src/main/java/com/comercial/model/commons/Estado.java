package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estado
{

    @Id
    @GeneratedValue
    private long id;
    
    @Column(unique = true, nullable = false, length = 100)
    private String nome;
    
    @Column(unique = true, nullable = false, length = 20)
    private String sigla;
    
    @ManyToOne
    private Pais pais;

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

    public String getSigla()
    {
        return sigla;
    }

    public void setSigla(String sigla)
    {
        this.sigla = sigla;
    }

    public Pais getPais()
    {
        return pais;
    }

    public void setPais(Pais pais)
    {
        this.pais = pais;
    }
    
    
    
}
