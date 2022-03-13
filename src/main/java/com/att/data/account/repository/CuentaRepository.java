package com.att.data.account.repository;

import org.springframework.stereotype.Repository;

import com.att.data.account.entity.CuentaEntity;
import com.att.data.account.entity.QCuentaEntity;
import com.att.data.account.vo.CuentaVO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

@Repository
public class CuentaRepository extends QueryDslBaseRepository<CuentaEntity>{

	public CuentaRepository() {
		super(CuentaEntity.class);
	}

	/**
	 * Registra los datos de la cuenta
	 * 
	 * @param cuentaVO Datos de la cuenta
	 */
	public void crearCuenta(CuentaVO cuentaVO) {
		CuentaEntity cuentaEntity = new CuentaEntity();
		cuentaEntity.setNumeroCuenta(cuentaVO.getNumeroCuenta());
		cuentaEntity.setTipoCuenta(cuentaVO.getTipoCuenta());
		cuentaEntity.setSaldoInicial(cuentaVO.getSaldoInicial());
		cuentaEntity.setCodigoCliente(cuentaVO.getClienteId());
		cuentaEntity.setEstado(Boolean.TRUE);
		save(cuentaEntity);
	}
	
	/**
	 * Obtener los datos de la cuenta
	 * 
	 * @param cuentaId Id de la cuenta
	 * @return CuentaEntity
	 */
	public CuentaEntity obtenerCuenta(Integer cuentaId) {
		return findById(cuentaId);
	}
	
	/**
	 * Actualiza el saldo inicial de la cuenta
	 * 
	 * @param cuentaId     Id de la cuenta
	 * @param sladoInicial Valor del saldo inicial
	 */
	public void actualizarCuenta(Integer cuentaId, Double sladoInicial) {
//		CuentaEntity cuentaEntity = this.obtenerCuenta(cuentaId);
//		cuentaEntity.setSaldoInicial(sladoInicial);
//		update(cuentaEntity);
		
		QCuentaEntity cuentaEntity = new QCuentaEntity("cuentaEntity");
		JPAUpdateClause jpaUpdate = new JPAQueryFactory(getEntityManager()).update(cuentaEntity);
		jpaUpdate.where(cuentaEntity.cuentaId.eq(cuentaId))
		.set(cuentaEntity.saldoInicial, sladoInicial)
		.execute();
	}
	
	/**
	 * Inactiva el registro de la cuenta
	 * 
	 * @param cuentaId Id de la cuenta
	 */
	public void eliminarCuenta(Integer cuentaId) {
		QCuentaEntity cuentaEntity = new QCuentaEntity("cuentaEntity");
		JPAUpdateClause jpaUpdate = new JPAQueryFactory(getEntityManager()).update(cuentaEntity);
		jpaUpdate.where(cuentaEntity.cuentaId.eq(cuentaId))
		.set(cuentaEntity.estado, Boolean.FALSE)
		.execute();
	}
	
	/**
	 * 
	 * @param numeroCuenta
	 * @param codigoCliente
	 * @return
	 */
	public String consultarCuenta(String numeroCuenta, Integer codigoCliente) {
		JPQLQuery<CuentaEntity> query = new JPAQuery<>(getEntityManager());
		QCuentaEntity cuentaEntity = new QCuentaEntity("cuentaEntity");
		CuentaVO cuenta = query.from(cuentaEntity).select(Projections.bean(CuentaVO.class, cuentaEntity.numeroCuenta)).
				where(cuentaEntity.numeroCuenta.eq(numeroCuenta), cuentaEntity.codigoCliente.eq(codigoCliente)).fetchOne();
		return cuenta.getNumeroCuenta();
		
	}
}
