package com.att.data.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.att.data.account.service.ClienteService;
import com.att.data.account.vo.ClienteResponseVO;
import com.att.data.account.vo.ClienteVO;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<ClienteResponseVO> guardarCliente(@RequestBody ClienteVO clienteVO) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		ClienteResponseVO response = new ClienteResponseVO();
		
		try {
			Integer personaId = clienteService.guardarCliente(clienteVO);
			clienteVO.setClienteId(personaId);
			
			response.setCodigo(HttpStatus.OK.value());
			response.setDescripcion("Datos del cliente registrado correctamente");
			
			response.setCliente(clienteVO);
			
            return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			response.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDescripcion(e.getCause().getMessage());
			response.setCause(e.getCause());
			return new ResponseEntity<>(response, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<ClienteResponseVO> actualizarCliente(@RequestBody ClienteVO clienteVO) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		ClienteResponseVO response = new ClienteResponseVO();
		
		try {
			clienteService.actualizarCliente(clienteVO);
			
			response.setCodigo(HttpStatus.OK.value());
			response.setDescripcion("Datos del cliente registrado correctamente");
			
			response.setCliente(clienteVO);
			
            return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			response.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDescripcion(e.getCause().getMessage());
			response.setCause(e.getCause());
			return new ResponseEntity<>(response, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<ClienteResponseVO> obtenerCliente(@RequestParam Integer clienteId) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		ClienteResponseVO response = new ClienteResponseVO();
		
		try {
			ClienteVO clienteVO = clienteService.obtenerCliente(clienteId);
			
			response.setCodigo(HttpStatus.OK.value());
			response.setDescripcion("Datos del cliente registrado correctamente");
			
			response.setCliente(clienteVO);
			
            return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			response.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDescripcion(e.getCause().getMessage());
			response.setCause(e.getCause());
			return new ResponseEntity<>(response, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<ClienteResponseVO> eliminarCliente(@RequestParam Integer clienteId) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		ClienteResponseVO response = new ClienteResponseVO();
		
		try {
			clienteService.eliminarCliente(clienteId);
			
			response.setCodigo(HttpStatus.OK.value());
			response.setDescripcion("El cliente a sido eliminado");
			
			ClienteVO clienteVO = new ClienteVO();
			clienteVO.setClienteId(clienteId);
			response.setCliente(clienteVO);
			
            return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			response.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDescripcion(e.getCause().getMessage());
			response.setCause(e.getCause());
			return new ResponseEntity<>(response, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

