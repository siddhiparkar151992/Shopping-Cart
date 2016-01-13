package com.client.shoppingcart.cart.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.bson.Document;

import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.businessobjects.user.User;
import com.client.shoppingcart.cart.dao.CartDaoImpl;
import com.client.shoppingcart.cart.dao.CartItemDaoImpl;
import com.client.shoppingcart.databaseconnection.DatabaseConnection;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class CartServiceImpl implements CartService{
	CartDaoImpl cartDaoImpl = new CartDaoImpl();


	@Override
	public void populateShoppingCartItem(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(ShoppingCart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(ShoppingCart cart, CartItem cartItem) {
		cartDaoImpl.save(cart, cartItem);
	}

	@Override
	public ShoppingCart getSHoppingCart(String id) {
		ShoppingCart cart = cartDaoImpl.getEntityById(id.toString());
		return cart;
		
	}

	@Override
	public ShoppingCart getShoppingCartByUser(int userId) {
		ShoppingCart cart = cartDaoImpl.getShoppingCartByUser(userId);
		return cart;
	}

	@Override
	public void save(ShoppingCart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItem(CartItem cartItem) {
		cartDaoImpl.addItem(cartItem);
		
	}

	@Override
	public ShoppingCart getShoppingCartWithProductdata(int id) {
		ShoppingCart cart = cartDaoImpl.getShoppingCartWithProductdata(id);
		return cart;
	}
	
	
	


}
