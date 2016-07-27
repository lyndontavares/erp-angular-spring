package com.comercial.model.autenticacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.comercial.model.autenticacao.views.View;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "sis_permissao")
 
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Permissao
{

    @Id
    @GeneratedValue
    @JsonView(View.class)
    private long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonView(View.class)
    private Usuario usuario;

    
    @ManyToOne
    @JoinColumn(name = "funcionalidade_id")
    @JsonView(View.class)
    private Funcionalidade funcionalidade;

    public Funcionalidade getFuncionalidade()
    {
        return funcionalidade;
    }

    public void setFuncionalidade(Funcionalidade funcionalidade)
    {
        this.funcionalidade = funcionalidade;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Permissao()
    {
    };

    public Permissao(long id, Usuario usuario, Funcionalidade funcionalidade)
    {
        super();
        this.id = id;
        this.usuario = usuario;
        this.funcionalidade = funcionalidade;
    }

}
