package com.productos.productosService.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productos.productosService.Service.ProductoService;
import com.productos.productosService.model.producto.Producto;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        Producto prodExistente = service.findById(id);
        if (prodExistente == null) return null;

        prodExistente.setNombre(producto.getNombre());
        prodExistente.setPrecio(producto.getPrecio());
        prodExistente.setCreateAt(producto.getCreateAt());
        prodExistente.setCategoria(producto.getCategoria());
        prodExistente.setDescripcion(producto.getDescripcion());

        return service.save(prodExistente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.deleteById(id);
    }
}