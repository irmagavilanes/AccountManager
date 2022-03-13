package com.att.data.account.vo;

import com.att.data.account.entity.ClienteEntity;

public class ClienteVO {

	private Integer clienteId;
	private String nombre;
	private String genero;
	private Integer edad;
	private String identificacion;
	private String direccion;
	private String telefono;
	private String contrasenia;
	private Boolean estado;
	
	public ClienteVO() {
	
	}

	public ClienteVO(ClienteEntity clienteEntity) {
		this.clienteId = clienteEntity.getClienteId();
		this.contrasenia = clienteEntity.getContrasenia();
		this.direccion = clienteEntity.getDireccion();
		this.edad = clienteEntity.getEdad();
		this.estado = clienteEntity.getEstado();
		this.genero = clienteEntity.getGenero();
		this.identificacion = clienteEntity.getIdentificacion();
		this.nombre = clienteEntity.getNombre();
		this.telefono = clienteEntity.getTelefono();

	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
