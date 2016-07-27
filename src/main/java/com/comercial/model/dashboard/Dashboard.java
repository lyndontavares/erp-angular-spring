package com.comercial.model.dashboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.comercial.model.dashboard.enums.SituacaoDash;
import com.comercial.model.sqldinamico.Artefato;

@Entity
public class Dashboard
{
    @Id
    @GeneratedValue
    private long id;
    
    @Column(unique = true, nullable = false, length = 100)
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private SituacaoDash situacao;
    @ManyToOne
    private Artefato artefato;

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

    public SituacaoDash getSituacao()
    {
        return situacao;
    }

    public void setSituacao(SituacaoDash situacao)
    {
        this.situacao = situacao;
    }

    public Artefato getArtefato()
    {
        return artefato;
    }

    public void setArtefato(Artefato artefato)
    {
        this.artefato = artefato;
    }

}
