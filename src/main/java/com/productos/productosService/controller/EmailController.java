package com.productos.productosService.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.productos.productosService.Service.EmailService;
import com.productos.productosService.model.producto.Usuario;
import com.productos.productosService.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/correo")
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {

    private final EmailService emailService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public EmailController(EmailService emailService, UsuarioRepository usuarioRepository) {
        this.emailService = emailService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/recuperar")
    public void recuperarContraseña(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String asunto = "Recuperación de contraseña";
        String cuerpo = "Haz clic en este enlace para recuperar tu contraseña:\n\nhttp://localhost:4200/restablecer?correo=" + correo;

        emailService.enviarCorreo(correo, asunto, cuerpo);
    }

    @PostMapping("/restablecer")
    public void restablecerContrasena(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String nuevaContrasena = datos.get("nuevaContrasena");

        Usuario usuario = usuarioRepository.findByCorreoElectronico(correo)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        usuario.setPassword(nuevaContrasena);
        usuarioRepository.save(usuario);
    }
}
