package com.att.data.account.repository;

import java.io.Serializable;

public interface IQueryDslBaseRepository<T> {

	/**
	 * Guardar una entidad
	 * 
	 * @param obj La entidad
	 */
	void save(T obj);
	
	/**
	 * Actualizar una entidad
	 * 
	 * @param obj La entidad
	 * @return La entidad
	 */
	T update(T obj);
	
	/**
	 * Bucar por id una entidad
	 * 
	 * @param id El id
	 * @return La entidad
	 */
	T findById(Serializable id);
}
