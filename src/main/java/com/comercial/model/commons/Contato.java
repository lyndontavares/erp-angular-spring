package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.comercial.model.commons.enums.ContatoTipo;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Contato
{

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false, length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    private ContatoTipo tipo;

    private String telefone;

    private String email;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Pessoa getPessoa()
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public ContatoTipo getTipo()
    {
        return tipo;
    }

    public void setTipo(ContatoTipo tipo)
    {
        this.tipo = tipo;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Contato [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", telefone=" + telefone + ", email=" + email
                + ", pessoa=" + pessoa + "]";
    }

    public Contato(long id, String nome, ContatoTipo tipo, String telefone, String email, Pessoa pessoa)
    {
        super();
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.telefone = telefone;
        this.email = email;
        this.pessoa = pessoa;
    }

    public Contato()
    {

    }

}
