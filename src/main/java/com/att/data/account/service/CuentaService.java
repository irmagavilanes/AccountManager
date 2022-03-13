package com.att.data.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.data.account.repository.CuentaRepository;
import com.att.data.account.vo.CuentaVO;

@Service
public class CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	public void guardarCuenta(CuentaVO cuentaVO) throws AOMException {
		
		try {
			
			this.validarCampos(cuentaVO);
			
			String numeroCuenta = cuentaRepository.consultarCuenta(cuentaVO.getNumeroCuenta(), cuentaVO.getClienteId());
			
			if (numeroCuenta != null && !numeroCuenta.equals(cuentaVO.getNumeroCuenta())) {
				cuentaRepository.crearCuenta(cuentaVO);
			} else {
				// El numero de cuenta existe para el usuario
				throw new AOMException("El numero de cuenta ingresado ya existe");
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 
	 * @param cuentaVO
	 * @throws AOMException
	 */
	private void validarCampos(CuentaVO cuentaVO) throws AOMException {
		if(cuentaVO.getNumeroCuenta() == null) {
			throw new AOMException("El numero de cuenta es requerido");
		} else if(cuentaVO.getSaldoInicial() == null) {
			throw new AOMException("El saldo inicial es requerido");
		} else if (cuentaVO.getTipoCuenta() == null) {
			throw new AOMException("El tipo de cuenta es requerido");
		} else if (cuentaVO.getClienteId() == null) {
			throw new AOMException("El cliente requerido");
		}
	}
}
