package com.comercial.model.commons;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemLote
{

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    private Lote lote;
    
    private BigDecimal quantidade;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Lote getLote()
    {
        return lote;
    }

    public void setLote(Lote lote)
    {
        this.lote = lote;
    }

    public BigDecimal getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade)
    {
        this.quantidade = quantidade;
    }

    public ItemLote(long id, Lote lote, BigDecimal quantidade)
    {
        super();
        this.id = id;
        this.lote = lote;
        this.quantidade = quantidade;
    }
    
    public ItemLote(){}

    @Override
    public String toString()
    {
        return "ItemLote [id=" + id + ", lote=" + lote + ", quantidade=" + quantidade + "]";
    }
    
    
    
}
