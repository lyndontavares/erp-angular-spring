package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubGrupo
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Grupo grupo;

    private String descricao;

    @Column(nullable = false, length = 50, unique = true)
    private String codigo;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Grupo getGrupo()
    {
        return grupo;
    }

    public void setGrupo(Grupo grupo)
    {
        this.grupo = grupo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public SubGrupo()
    {
    };

    public SubGrupo(long id, Grupo grupo, String descricao, String codigo)
    {
        super();
        this.id = id;
        this.grupo = grupo;
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public SubGrupo(long id)
    {
        super();
        this.id = id;
    }

}
