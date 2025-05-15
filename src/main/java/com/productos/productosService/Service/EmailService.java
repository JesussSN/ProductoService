package com.productos.productosService.Service;

public interface EmailService {

	public void enviarCorreo(String destinatario, String asunto, String cuerpo);
}
