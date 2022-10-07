package com.dfont.gestion_productos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfont.gestion_productos.repositories.ProductoRepository;
import com.dfont.gestion_productos.models.Producto;

@Service
public class ProductoServicio {

	@Autowired
	private ProductoRepository repositorio;
	
	public List<Producto> listarProductos(){
		return repositorio.findAll();
	}
	
	public void guardarProducto(Producto p) {
		repositorio.save(p);
	}
	
	public void guardarProductos(List<Producto> lista) {
		repositorio.saveAll(lista);
	}
	
	public Producto obtenerProductoPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void eliminarPorId(Integer id) {
		repositorio.deleteById(id);
	}
}
