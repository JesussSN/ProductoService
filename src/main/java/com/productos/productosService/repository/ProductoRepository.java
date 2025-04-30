package com.productos.productosService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.productosService.model.producto.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
