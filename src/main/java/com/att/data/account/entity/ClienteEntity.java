/**
 * 
 */
package com.att.data.account.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author igavilanes
 *
 */
@Entity
@Table(name = "CLIENTE")
@PrimaryKeyJoinColumn(name="personaId")
public class ClienteEntity extends PersonaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 512408327396054807L;

	//@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clienteId;
	
	private String contrasenia;
	private Boolean estado;
		
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
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
