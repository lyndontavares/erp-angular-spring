package com.comercial.model.autenticacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.comercial.model.autenticacao.enums.UsuarioSituacao;
import com.comercial.model.autenticacao.enums.UsuarioTipo;
import com.comercial.model.autenticacao.views.View;
import com.comercial.model.commons.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
 

@Entity
@Table(name="sis_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true, nullable=false,length=100) 
	private String nome;
	
	@Column(unique=true, nullable=false,length=20) 
	private String login;
	
	@JsonIgnore
	@Column(nullable=false,length=20) 
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private UsuarioSituacao situacao;
	
	@Enumerated(EnumType.STRING)
	private UsuarioTipo admin;
	
	@ManyToOne
	@JsonView(View.class)
	private Pessoa pessoa;

	public UsuarioTipo getAdmin() {
		return admin;
	}

	public void setAdmin(UsuarioTipo admin) {
		this.admin = admin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(UsuarioSituacao situacao) {
		this.situacao = situacao;
	}
	
    public Pessoa getPessoa()
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }


	public Usuario(String nome, String login, String senha, UsuarioSituacao situacao, UsuarioTipo admin) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.situacao = situacao;
		this.admin = admin;
	}
	
    public Usuario(String login, String senha) {
        super();
        this.login = login;
        this.senha = senha;
    }

	public Usuario( String nome, String login, String senha, UsuarioSituacao situacao, UsuarioTipo admin,
            Pessoa pessoa)
    {
        super();
 
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.situacao = situacao;
        this.admin = admin;
        this.pessoa = pessoa;
    }

    public Usuario(){
		
	}


}
