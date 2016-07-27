package com.comercial.model.autenticacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sis_grup_usuaurio")
public class GrupoUsuario {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true, nullable = false, length = 100)
	private String descricao;
 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GrupoUsuario(long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", descricao=" + descricao + "]";
	}
	
	public GrupoUsuario(){
		
	}
	
}
