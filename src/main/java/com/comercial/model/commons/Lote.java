package com.comercial.model.commons;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Lote
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Estoque estoque;

    @NotNull
    private String identificador;

    @NotNull
    private BigDecimal quantidade;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Estoque getEstoque()
    {
        return estoque;
    }

    public void setEstoque(Estoque estoque)
    {
        this.estoque = estoque;
    }

    public String getIdentificador()
    {
        return identificador;
    }

    public void setIdentificador(String identificador)
    {
        this.identificador = identificador;
    }

    public BigDecimal getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade)
    {
        this.quantidade = quantidade;
    }

    public Lote(long id, Estoque estoque, String identificador, BigDecimal quantidade)
    {
        super();
        this.id = id;
        this.estoque = estoque;
        this.identificador = identificador;
        this.quantidade = quantidade;
    }

    public Lote()
    {
    }

    @Override
    public String toString()
    {
        return "Lote [id=" + id + ", estoque=" + estoque + ", identificador=" + identificador + ", quantidade="
                + quantidade + "]";
    }

}
