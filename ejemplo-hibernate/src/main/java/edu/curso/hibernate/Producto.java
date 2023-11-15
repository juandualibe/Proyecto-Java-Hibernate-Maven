package edu.curso.hibernate;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "productos") //ESTO ES OPCIONAL
public class Producto {

	@Id // PK DE LA TABLA PRODUCTOS
	@GeneratedValue // VALOR DEL ID AUTO GENERADO
	private Long id;
	private String nombre;
	private Double precio;
	
	@ManyToMany
	private List<Sucursal> sucursales = new ArrayList<Sucursal>();
	
	public List<Sucursal> getSucursales() {
		return sucursales;
	}
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	@OneToMany
	private List<Fabricante> fabricantes = new ArrayList<Fabricante>();
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	private CategoriaProducto categoriaProducto;
	
	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}
	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	
	@Column(name = "descripcionCompleta")
	private String descripcion;
	
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
