package com.att.data.account.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * Repositorio base con soporte a querydsl
 *
 * @param <T> La clase base del repositorio
 */
public abstract class QueryDslBaseRepository<T> extends QuerydslRepositorySupport implements IQueryDslBaseRepository<T>{

	private final Class<?> domainClass;
	
	public QueryDslBaseRepository(Class<?> domainClass) {
		super(domainClass);
		this.domainClass = domainClass;
	}

	@Override
	public void save(T obj) {
		getEntityManager().persist(obj);
	}
	
	@Override
	public T update(T obj) {
		return getEntityManager().merge(obj);
	}
	
	@SuppressWarnings("unchecked")
	@Override 
	public T findById(Serializable id) {
		return (T) getEntityManager().find(domainClass, id);
	}
}
