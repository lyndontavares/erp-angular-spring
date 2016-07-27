package com.comercial.model.commons;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Pedido pedido;

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

    public Pedido getPedido()
    {
        return pedido;
    }

    public void setPedido(Pedido pedido)
    {
        this.pedido = pedido;
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

    public ItemPedido()
    {
    };

    public ItemPedido(long id, Pedido pedido, Estoque produto, BigDecimal valorUnitario, BigDecimal quantidade,
            BigDecimal valorItem)
    {
        super();
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorItem = valorItem;
    }

}
