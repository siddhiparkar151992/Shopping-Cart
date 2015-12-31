package com.client.shoppingcart.Entity;

public abstract class Entity<K> {
	 /* 
	 * @return id
	 */
	public abstract K getId();

	/**
	 * D�finit la valeur de l'identifiant unique.
	 * 
	 * @param id id
	 */
	public abstract void setId(K id);
	
	/**
	 * Indique si l'objet a d�j� �t� persist� ou non
	 * 
	 * @return vrai si l'objet n'a pas encore �t� persist�
	 */
	public boolean isNew() {
		return getId() == null;
	}
	
	
}
