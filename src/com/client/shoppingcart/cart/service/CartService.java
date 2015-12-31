package com.client.shoppingcart.cart.service;

import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.businessobjects.user.User;

public interface CartService {
	ShoppingCart getSHoppingCart(User user);

	void save(ShoppingCart cart);

	void populateShoppingCartItem(Product product);

	void deleteCart(ShoppingCart cart);

}
