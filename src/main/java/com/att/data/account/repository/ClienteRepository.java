/**
 * 
 */
package com.att.data.account.repository;

import org.springframework.stereotype.Repository;

import com.att.data.account.entity.ClienteEntity;
import com.att.data.account.entity.QClienteEntity;
import com.att.data.account.vo.ClienteVO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

/**
 * @author igavilanes
 *
 */
@Repository
public class ClienteRepository extends QueryDslBaseRepository<ClienteEntity> {

	/**
	 * Constructor
	 */
	public ClienteRepository() {
		super(ClienteEntity.class);
	}

	/**
	 * Registrar los datos del cliente
	 * 
	 * @param cliente Datos del cliente
	 */
	public Integer guardarClient(ClienteVO cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setNombre(cliente.getNombre());
		clienteEntity.setDireccion(cliente.getContrasenia());
		clienteEntity.setTelefono(cliente.getTelefono());
		clienteEntity.setContrasenia(cliente.getContrasenia());
		clienteEntity.setGenero(cliente.getGenero());
		clienteEntity.setEdad(cliente.getEdad());
		clienteEntity.setIdentificacion(cliente.getIdentificacion());
		clienteEntity.setEstado(Boolean.TRUE);
		save(clienteEntity);

		return clienteEntity.getPersonaId();

	}

	/**
	 * Actualizar los datos del cliente
	 * 
	 * @param cliente Datos a actualizar
	 */
	public void actualizarCliente(ClienteVO cliente) {

		ClienteEntity clienteEntity = findById(cliente.getClienteId());

		if (cliente.getContrasenia() != null) {
			clienteEntity.setContrasenia(cliente.getContrasenia());
		}
		
		if (cliente.getDireccion() != null) {
			clienteEntity.setDireccion(cliente.getDireccion());
		}
		
		if (cliente.getEdad() != null) {
			clienteEntity.setEdad(cliente.getEdad());
		}
		
		if (cliente.getGenero() != null) {
			clienteEntity.setGenero(cliente.getGenero());
		}
		
		if (cliente.getIdentificacion() != null) {
			clienteEntity.setIdentificacion(cliente.getIdentificacion());
		}
		
		if (cliente.getNombre() != null) {
			clienteEntity.setNombre(cliente.getNombre());
		}
		
		if (cliente.getTelefono() != null) {
			clienteEntity.setTelefono(cliente.getTelefono());
		}		

		update(clienteEntity);
	}

	/**
	 * Obtener los datos del cliente
	 * 
	 * @param clienteId Id del cliente
	 * @return ClienteEntity Datos del cliente
	 */
	public ClienteVO obtenerCliente(Integer clienteId) {
		return new ClienteVO(findById(clienteId));

	}

	/**
	 * Inactivar el registro del cliente
	 * 
	 * @param clienteId Id del cliente
	 */
	public void eliminarCliente(Integer clienteId) {
		QClienteEntity clienteEntity = new QClienteEntity("clienteEntity");
		JPAUpdateClause jpaUpdate = new JPAQueryFactory(getEntityManager()).update(clienteEntity);
		jpaUpdate.where(clienteEntity.personaId.eq(clienteId)).set(clienteEntity.estado, Boolean.FALSE).execute();
	}

}
