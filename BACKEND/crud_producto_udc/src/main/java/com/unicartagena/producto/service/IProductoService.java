package com.unicartagena.producto.service;

import java.util.List;

import com.unicartagena.producto.entity.ProductoEntity;


public interface IProductoService{

	//Listar todo
	public List<ProductoEntity> all();
	
	//Guardar
	public ProductoEntity save(ProductoEntity productoEntity);
		
}