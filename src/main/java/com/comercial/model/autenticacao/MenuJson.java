package com.comercial.model.autenticacao;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MenuJson {

	private long id;
	
	private String opcao;
	
	private String rota;
	
	private String controller;
	
	private long pai;

	@ManyToOne
	@JoinColumn(name="funcionalidade_id")
	private Funcionalidade funcionalidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public long getPai() {
		return pai;
	}

	public void setPai(long pai) {
		this.pai = pai;
	}

	@Override
	public String toString() {
		return "MenuJson [id=" + id + ", opcao=" + opcao + ", pai=" + pai + "]";
	}
	

	public MenuJson(long id, String opcao, String rota, String controller,
			Funcionalidade funcionalidade, long pai) {
		super();
		this.id = id;
		this.opcao = opcao;
		this.rota = rota;
		this.controller = controller;
		this.funcionalidade = funcionalidade;
		this.pai = pai;
	}

	public MenuJson(){
		
	}

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}
	
}
