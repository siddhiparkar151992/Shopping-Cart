package com.client.shoppingcart.cart.service;

import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.businessobjects.user.User;

public interface CartService {
	ShoppingCart getShoppingCartByUser(int userId);
	ShoppingCart getSHoppingCart(String id);
	
	void save(ShoppingCart cart);
	void addItem(CartItem cartItem);
	void populateShoppingCartItem(Product product);

	void deleteCart(ShoppingCart cart);

	void save(ShoppingCart cart, CartItem cartItem);

}
