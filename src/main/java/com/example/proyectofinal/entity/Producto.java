package com.example.proyectofinal.entity;

public class Producto {
	private Long id;
    private String nombre;
    private Double precio;
    private Long categoriaId;
	public Producto(Long id, String nombre, Double precio, Long categoriaId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoriaId = categoriaId;
	}
	public Producto() {
	}
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
    
}
