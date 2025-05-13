package com.productos.productosService.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.productos.productosService.Service.UsuarioService;
import com.productos.productosService.model.producto.Usuario;
import com.productos.productosService.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario crear(Usuario usuario) {
    	logger.info("Usuario recibido: {}", usuario);
    	return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioActualizado.getNombre());
                    usuario.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
                    usuario.setTelefono(usuarioActualizado.getTelefono());
                    usuario.setDireccion(usuarioActualizado.getDireccion());
                    usuario.setPassword(usuarioActualizado.getPassword());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    public Optional<Usuario> findByCorreoElectronico(String correoElectronico) {
        return usuarioRepository.findByCorreoElectronico(correoElectronico);
    }

}
