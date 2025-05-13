package com.productos.productosService.model.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	@Column(name="correo_electronico")
	@JsonProperty("correo_electronico")
	private String correoElectronico;
	private String telefono;
	private String direccion;
	@Column(nullable = false)
	private String password;


	    // Getters y Setters
	 public Long getId() { return id; }
	 public void setId(Long id) { this.id = id; }

	 public String getNombre() { return nombre; }
	 public void setNombre(String nombre) { this.nombre = nombre; }

	 public String getCorreoElectronico() { return correoElectronico; }
	 public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

	 public String getTelefono() { return telefono; }
	 public void setTelefono(String telefono) { this.telefono = telefono; }

	 public String getDireccion() { return direccion; }
	 public void setDireccion(String direccion) { this.direccion = direccion; }

	 public String getPassword() { return password; }
	 public void setPassword(String password) { this.password = password; }
}


