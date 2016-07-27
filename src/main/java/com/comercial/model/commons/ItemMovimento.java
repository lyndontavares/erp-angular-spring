package com.comercial.model.commons;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemMovimento
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private MovimentoProduto movimento;
    
    @ManyToOne
    private Estoque estuque;
    
    private BigDecimal quantidade;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public MovimentoProduto getMovimento()
    {
        return movimento;
    }

    public void setMovimento(MovimentoProduto movimento)
    {
        this.movimento = movimento;
    }

    public Estoque getEstuque()
    {
        return estuque;
    }

    public void setEstuque(Estoque estuque)
    {
        this.estuque = estuque;
    }

    public BigDecimal getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade)
    {
        this.quantidade = quantidade;
    }
    
    
    
}
