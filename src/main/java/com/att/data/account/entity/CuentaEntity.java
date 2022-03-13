/**
 * 
 */
package com.att.data.account.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author igavilanes
 *
 */
@Entity
@Table(name = "CUENTA")
public class CuentaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1259159960399252344L;

	@Id
	@GeneratedValue
	private Integer cuentaId;
	
	private String numeroCuenta;
	private String tipoCuenta;
	private Double saldoInicial;
	private Boolean estado;
	
	private Integer codigoCliente;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CODIGOCLIENTE", referencedColumnName = "CLIENTEID", insertable = false, updatable = false)
//	private ClienteEntity cliente;

	public Integer getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

//	public ClienteEntity getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(ClienteEntity cliente) {
//		this.cliente = cliente;
//	}
	
}
