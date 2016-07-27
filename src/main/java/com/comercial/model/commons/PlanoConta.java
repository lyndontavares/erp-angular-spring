package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.comercial.model.commons.enums.TipoPlano;

@Entity
public class PlanoConta
{

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 100, nullable = false)
    private String descricao;

    @Column(length = 50, nullable = false, unique = true)
    private String codigo;

    @Enumerated(EnumType.STRING)
    private TipoPlano tipoPlano;

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

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public TipoPlano getTipoPlano()
    {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano)
    {
        this.tipoPlano = tipoPlano;
    }

    public PlanoConta()
    {
    };

    public PlanoConta(long id, String descricao, String codigo, TipoPlano tipoPlano)
    {
        super();
        this.id = id;
        this.descricao = descricao;
        this.codigo = codigo;
        this.tipoPlano = tipoPlano;
    }

}
