package com.dfont.gestion_productos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dfont.gestion_productos.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
