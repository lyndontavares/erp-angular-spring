package com.comercial.model.commons;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FichaProduto
{
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Estoque produto;

    @Temporal(TemporalType.DATE)
    private Date data;

    private BigDecimal saldo;

    private BigDecimal custo;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Estoque getProduto()
    {
        return produto;
    }

    public void setProduto(Estoque produto)
    {
        this.produto = produto;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public BigDecimal getSaldo()
    {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo)
    {
        this.saldo = saldo;
    }

    public BigDecimal getCusto()
    {
        return custo;
    }

    public void setCusto(BigDecimal custo)
    {
        this.custo = custo;
    }

    public FichaProduto()
    {
    };

    public FichaProduto(long id, Estoque produto, Date data, BigDecimal saldo, BigDecimal custo)
    {
        super();
        this.id = id;
        this.produto = produto;
        this.data = data;
        this.saldo = saldo;
        this.custo = custo;
    }

}
