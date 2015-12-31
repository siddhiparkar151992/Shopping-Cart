package com.client.shoppingcart.cart.dao;

import org.bson.Document;

import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.databaseconnection.DatabaseConnection;
import com.mongodb.client.MongoCollection;

public class CartItemDaoImpl implements CartItemDAO{
	static MongoCollection<Document> cartItemCollection = DatabaseConnection.getConnection().getCollection("shoppingCartItem");
	private ShoppingCart cart;
	
	@Override
	public CartItem getEntity(Class<? extends CartItem> className, CartItem id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem getEntityById(CartItem id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CartItem cartItem) {
		Document cartItemDoc=new Document().append("", value)
		cartItemCollection.insertOne(arg0);
		
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
