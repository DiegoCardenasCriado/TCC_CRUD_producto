package com.unicartagena.producto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Notaciones de entidades para modelo de datos
@Entity 
@Table(name = "producto") //Nombre de la tabla
public class ProductoEntity implements Serializable{
	
	// Versionamiento de la entidad
	private static final long serialVersionUID = 1L;
	
	//Atributos (Columnas)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementable
	private long id;
	
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "descripcion", length = 40, nullable = false)
	private String descripcion;
	
	@Column(name = "precio_compra", nullable = false)
	private double precio_compra;
	
	@Column(name = "precio_venta", nullable = false)
	private double precio_venta;
	
	@Column(name = "num_lote", length = 20, nullable = false)
	private String num_lote;
	
	@Column(name = "categoria", length = 20, nullable = false)
	private String categoria;
	
	@Column(name = "origen", length = 20, nullable = false)
	private String origen;

	//Getters y Setters
	
	public long getId() {
		return id;
	}

//	public void setId(long id) {
//		this.id = id;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getNum_lote() {
		return num_lote;
	}

	public void setNum_lote(String num_lote) {
		this.num_lote = num_lote;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	
	
	}
