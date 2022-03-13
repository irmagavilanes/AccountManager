package com.att.data.account.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.data.account.repository.ClienteRepository;
import com.att.data.account.vo.ClienteVO;

@Transactional
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Integer guardarCliente(ClienteVO clienteVO) throws AOMException {
		try {
			return clienteRepository.guardarClient(clienteVO);
		} catch (Exception e) {
			throw new AOMException(e.getMessage(), e);
		}
	}

	public void actualizarCliente(ClienteVO clienteVO) throws AOMException {
		try {
			clienteRepository.actualizarCliente(clienteVO);
		} catch (Exception e) {
			throw new AOMException(e.getMessage(), e);
		}
	}

	public ClienteVO obtenerCliente(Integer personaId) throws AOMException {
		try {
			return clienteRepository.obtenerCliente(personaId);
		} catch (Exception e) {
			throw new AOMException(e.getMessage(), e);
		}
	}

	public void eliminarCliente(Integer personaId) throws AOMException {
		try {
			clienteRepository.eliminarCliente(personaId);
		} catch (Exception e) {
			throw new AOMException(e.getMessage(), e);
		}
	}

}
