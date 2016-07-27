package com.comercial.model.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transportador
{
    
    @Id
    @GeneratedValue
    private long id;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Transportador [id=" + id + "]";
    }
    
    
}
