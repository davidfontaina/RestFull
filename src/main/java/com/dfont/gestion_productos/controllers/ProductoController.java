package com.dfont.gestion_productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dfont.gestion_productos.models.Producto;
import com.dfont.gestion_productos.services.ProductoServicio;

import lombok.Delegate;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoServicio servicio;
	
	@GetMapping("/producto")
	public List<Producto> listarProductos(){
		return servicio.listarProductos();
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
		try {
			Producto producto= servicio.obtenerProductoPorId(id);
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/producto")
	public ResponseEntity<?> guardarProducto(@RequestBody Producto producto) {
		try {
			servicio.guardarProducto(producto);
			return new ResponseEntity<Producto>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> actualizarProducto(
			@RequestBody Producto producto, 
			@PathVariable Integer id){
		try {
			Producto productoExistente = servicio.obtenerProductoPorId(id);
			productoExistente.setNombre(producto.getNombre());
			productoExistente.setPrecio(producto.getPrecio());
			servicio.guardarProducto(productoExistente);
			return new ResponseEntity<Producto>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
		try {
			servicio.eliminarPorId(id);
			return new ResponseEntity<Producto>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
}
