package com.comercial.model.autenticacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sis_membro")
public class Membro {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="usurio_id")
	private Usuario usuario;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Membro(long id, Usuario usuario) {
		super();
		this.id = id;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Membro [id=" + id + ", usuario=" + usuario + "]";
	}
	
	public Membro(){
		
	}
	
}
