package com.comercial.model.commons;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MovimentoProduto
{
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Filial fillial;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Filial getFillial()
    {
        return fillial;
    }

    public void setFillial(Filial fillial)
    {
        this.fillial = fillial;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }
    
    
}
