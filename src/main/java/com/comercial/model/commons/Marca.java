package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Marca {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false,unique=true)
	private String marca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", marca=" + marca + "]";
	}

	public Marca(long id, String marca) {
		super();
		this.id = id;
		this.marca = marca;
	}

	public Marca() {
	}
}
