package com.comercial.model.commons;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.comercial.model.commons.enums.Moeda;

@Entity
@Table(indexes = { @Index(columnList = "moeda_origem,moeda_destino,data", unique = true) })
public class Cotacao
{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "moeda_origem")
    private Moeda moedaOrigem;

    @Column(name = "moeda_destino")
    private Moeda moedaDestino;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(nullable = false)
    private BigDecimal valor;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Moeda getMoedaOrigem()
    {
        return moedaOrigem;
    }

    public void setMoedaOrigem(Moeda moedaOrigem)
    {
        this.moedaOrigem = moedaOrigem;
    }

    public Moeda getMoedaDestino()
    {
        return moedaDestino;
    }

    public void setMoedaDestino(Moeda moedaDestino)
    {
        this.moedaDestino = moedaDestino;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public BigDecimal getValor()
    {
        return valor;
    }

    public void setValor(BigDecimal valor)
    {
        this.valor = valor;
    }

    public Cotacao()
    {
    };

    public Cotacao(long id, Moeda moedaOrigem, Moeda moedaDestino, Date data, BigDecimal valor)
    {
        super();
        this.id = id;
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.data = data;
        this.valor = valor;
    }

}
