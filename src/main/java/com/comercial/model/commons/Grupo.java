package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grupo {

	@Id
	@GeneratedValue
	private long id;

	 @Column(unique = true, nullable = false, length = 100)
	private String grupo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", grupo=" + grupo + "]";
	}

	public Grupo(long id, String grupo) {
		super();
		this.id = id;
		this.grupo = grupo;
	}

	public Grupo() {
	}

}
