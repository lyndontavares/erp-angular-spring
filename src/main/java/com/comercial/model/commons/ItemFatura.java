package com.comercial.model.commons;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemFatura
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Fatura fatura;

    @ManyToOne
    private Estoque produto;

    private BigDecimal valorUnitario;

    private BigDecimal quantidade;

    private BigDecimal valorItem;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Fatura getFatura()
    {
        return fatura;
    }

    public void setFatura(Fatura fatura)
    {
        this.fatura = fatura;
    }

    public Estoque getProduto()
    {
        return produto;
    }

    public void setProduto(Estoque produto)
    {
        this.produto = produto;
    }

    public BigDecimal getValorUnitario()
    {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario)
    {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade)
    {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorItem()
    {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem)
    {
        this.valorItem = valorItem;
    }

    public ItemFatura()
    {
    };

    public ItemFatura(long id, Fatura fatura, Estoque produto, BigDecimal valorUnitario, BigDecimal quantidade,
            BigDecimal valorItem)
    {
        super();
        this.id = id;
        this.fatura = fatura;
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorItem = valorItem;
    }

}
