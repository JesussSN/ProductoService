package com.productos.productosService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.productosService.model.producto.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByCorreoElectronico(String correoElectronico);

}