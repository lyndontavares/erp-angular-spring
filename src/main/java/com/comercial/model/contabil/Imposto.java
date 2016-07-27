package com.comercial.model.contabil;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.comercial.model.commons.Pais;
import com.comercial.model.contabil.enums.SituacaoImposto;

@Entity
public class Imposto
{
    @Id
    @GeneratedValue
    private long id;
    
    private String nome;
    
    @ManyToOne
    private Pais pais;

    @Enumerated(EnumType.STRING)
    private SituacaoImposto situacao;

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

    public Pais getPais()
    {
        return pais;
    }

    public void setPais(Pais pais)
    {
        this.pais = pais;
    }

    public SituacaoImposto getSituacao()
    {
        return situacao;
    }

    public void setSituacao(SituacaoImposto situacao)
    {
        this.situacao = situacao;
    }
    
    
    
}
