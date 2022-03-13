/**
 * 
 */
package com.att.data.account.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author igavilanes
 *
 */
@Entity
@Table(name = "MOVIMIENTO")
public class MovimientoEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1396467766108220494L;

	@Id
	@GeneratedValue
	private Integer movimientoId;
	
	private Date fecha;
	private String tipoMovimiento;
	private Double valor;
	private Double saldo;
	private Integer codigoMovimiento;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CODIGOMOVIMIENTO", referencedColumnName = "CUENTAID", insertable = false, updatable = false)
//	private CuentaEntity cuenta;

	public Integer getMovimientoId() {
		return movimientoId;
	}

	public void setMovimientoId(Integer movimientoId) {
		this.movimientoId = movimientoId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getCodigoMovimiento() {
		return codigoMovimiento;
	}

	public void setCodigoMovimiento(Integer codigoMovimiento) {
		this.codigoMovimiento = codigoMovimiento;
	}

//	public CuentaEntity getCuenta() {
//		return cuenta;
//	}
//
//	public void setCuenta(CuentaEntity cuenta) {
//		this.cuenta = cuenta;
//	}

}
