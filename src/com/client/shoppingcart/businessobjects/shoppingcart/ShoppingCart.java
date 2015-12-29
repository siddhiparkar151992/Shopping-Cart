package com.client.shoppingcart.businessobjects.shoppingcart;

import com.client.shoppingcart.Entity.EntityManagerImpl;

public class ShoppingCart extends EntityManagerImpl {
	private int cartId;
	private int customerID;
	public int getcartId() {
		return cartId;
	}

	public void setcartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	@Override
	public Object getEntity(Class className, Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
