package com.productos.productosService.Service;

import java.util.List;
import java.util.Optional;

import com.productos.productosService.model.producto.Usuario;

public interface UsuarioService {

	public List<Usuario> obtenerTodos();
    public Optional<Usuario> obtenerPorId(Long id);
    public Usuario crear(Usuario usuario);
    public Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
    public Optional<Usuario> findByCorreoElectronico(String correoElectronico);
}
