package com.client.shoppingcart.cart.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import org.bson.Document;

import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.databaseconnection.DatabaseConnection;
import com.mongodb.client.MongoCollection;

public  class CartItemDaoImpl implements CartItemDAO{
	
	

	@Override
	public CartItem prepareCartitem(CartItem cartItem) {
		Random randomno = new Random();
		cartItem.setId(randomno.nextLong());
		cartItem.setSubTotal(cartItem.getItemPrice()*cartItem.getQuantity());
		return cartItem;
	}

	@Override
	public CartItem getEntity(CartItem id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem getEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CartItem entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CartItem entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CartItem entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
