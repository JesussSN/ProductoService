package com.productos.productosService.Service;

import java.util.List;
import java.util.Optional;

import com.productos.productosService.model.producto.Usuario;

public interface UsuarioService {

	List<Usuario> obtenerTodos();
    Optional<Usuario> obtenerPorId(Long id);
    Usuario crear(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
}
