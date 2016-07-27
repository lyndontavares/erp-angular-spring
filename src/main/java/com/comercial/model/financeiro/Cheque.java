package com.comercial.model.financeiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cheque
{

    @Id
    @GeneratedValue
    private long id;
 
    private long numero;
    
    @ManyToOne
    private Talao talao;

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

    public Talao getTalao()
    {
        return talao;
    }

    public void setTalao(Talao talao)
    {
        this.talao = talao;
    }
    
}
