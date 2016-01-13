package com.client.shoppingcart.cart.dao;

import java.util.UUID;

import org.bson.Document;

import com.client.shoppingcart.Entity.EntityDao;
import com.client.shoppingcart.Entity.EntityManagerImpl;
import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.mongodb.client.MongoCursor;

public interface CartDAO extends EntityDao<ShoppingCart>{
	void save(ShoppingCart cart, CartItem cartItem);
	ShoppingCart getShoppingCartByUser(int id);
	void addItem(CartItem item);
	ShoppingCart getShoppingCartWithProductdata(int id);
}
