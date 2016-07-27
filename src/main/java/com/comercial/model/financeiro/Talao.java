package com.comercial.model.financeiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Talao
{
    @Id
    @GeneratedValue
    private long id;
    
    private long numero;
    
    private long inicio;
    
    private long fim;
    
    
    public long getInicio()
    {
        return inicio;
    }

    public void setInicio(long inicio)
    {
        this.inicio = inicio;
    }

    public long getFim()
    {
        return fim;
    }

    public void setFim(long fim)
    {
        this.fim = fim;
    }

    @ManyToOne
    private Agencia agencia;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getNumero()
    {
        return numero;
    }

    public void setNumero(long numero)
    {
        this.numero = numero;
    }

    public Agencia getAgencia()
    {
        return agencia;
    }

    public void setAgencia(Agencia agencia)
    {
        this.agencia = agencia;
    }
    
    

}
