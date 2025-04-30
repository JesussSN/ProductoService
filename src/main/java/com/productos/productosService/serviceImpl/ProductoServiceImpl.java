package com.productos.productosService.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productos.productosService.Service.ProductoService;
import com.productos.productosService.model.producto.Producto;
import com.productos.productosService.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}