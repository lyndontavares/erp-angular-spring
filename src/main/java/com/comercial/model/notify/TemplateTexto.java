package com.comercial.model.notify;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TemplateTexto
{
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false, length = 100)
    public String nome;

    private String texto;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public TemplateTexto(long id, String texto, String nome)
    {
        super();
        this.id = id;
        this.texto = texto;
        this.nome = nome;
    }

    public TemplateTexto()
    {
    }

    @Override
    public String toString()
    {
        return "Template [id=" + id + ", texto=" + texto + ", nome=" + nome + "]";
    }

}
