package com.comercial.model.commons;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.comercial.model.commons.enums.PessoaRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role
{

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private PessoaRole pessoaRole;

 
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Pessoa getPessoa()
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }

    public PessoaRole getPessoaRole()
    {
        return pessoaRole;
    }

    public void setPessoaRole(PessoaRole pessoaRole)
    {
        this.pessoaRole = pessoaRole;
    }

    public Role()
    {
    };

    public Role(long id, Pessoa pessoa, PessoaRole pessoaRole)
    {
        super();
        this.id = id;
        this.pessoa = pessoa;
        this.pessoaRole = pessoaRole;
    }

 
   
    

}
