package com.unicartagena.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unicartagena.producto.entity.ProductoEntity;
import com.unicartagena.producto.service.IProductoService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/producto")
public class ProductoController {
	
	//Accedemos a los metodos de la interface de ProductoService
	@Autowired
	private IProductoService productoService;
	
	//Con el metodo GET sin parametros consultamos todos los registros
	@GetMapping
	public List<ProductoEntity> all(){
		return this.productoService.all();
	}
	
	//Con el metodo POST creamos los registros
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductoEntity save (@RequestBody ProductoEntity productoEntity) {
		return this.productoService.save(productoEntity);
	}

	//Con el metodo DELETE eliminamos los registros por ID
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.productoService.deleteById(id);
	}
}
