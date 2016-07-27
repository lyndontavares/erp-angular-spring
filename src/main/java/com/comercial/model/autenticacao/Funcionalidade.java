package com.comercial.model.autenticacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@Table(name = "sis_funcionalidade")
 
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Funcionalidade
{

    @Id
    private long id;

    @Column(unique = true, nullable = false, length = 100)
    private String descricao;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    @Override
    public String toString()
    {
        return "Funcionalidade [descricao=" + descricao + "]";
    }

    public Funcionalidade()
    {
    };

    public Funcionalidade(long id, String descricao)
    {
        super();
        this.id = id;
        this.descricao = descricao;
    }

}
