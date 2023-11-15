package edu.curso.hibernate;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class CategoriaProducto {

	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(length = 400)
	private String nombre;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	
}
