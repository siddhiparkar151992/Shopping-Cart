package com.client.shoppingcart.Entity;

public interface EntityDao<E> {
	E getEntity(E id);
	E getEntityById(E id);
	void save(E entity);
	void update(E entity);
	void delete(E entity);
	int count();
}
