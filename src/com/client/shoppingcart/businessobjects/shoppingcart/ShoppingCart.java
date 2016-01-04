package com.client.shoppingcart.businessobjects.shoppingcart;

import java.util.Set;

import com.client.shoppingcart.Entity.EntityManagerImpl;

public class ShoppingCart extends EntityManagerImpl {
	private String cartId;
	private int customerID;
	private Set<CartItem> CartItems;
	public ShoppingCart(String cartId, int customerID, Set<CartItem> cartItems) {
		super();
		this.cartId = cartId;
		this.customerID = customerID;
		CartItems = cartItems;
	}

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Set<CartItem> getCartItems() {
		return CartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		CartItems = cartItems;
	}

	public String getcartId() {
		return cartId;
	}

	public void setcartId(String cartId) {
		this.cartId = cartId;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	@Override
	public Object getEntity(Object id) {
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
