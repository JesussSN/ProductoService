package com.productos.productosService.Service;

import java.util.List;

import com.productos.productosService.model.producto.Producto;

public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);
}
