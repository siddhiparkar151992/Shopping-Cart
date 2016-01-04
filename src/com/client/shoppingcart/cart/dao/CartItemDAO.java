package com.client.shoppingcart.cart.dao;

import com.client.shoppingcart.Entity.EntityDao;
import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;

public interface CartItemDAO extends EntityDao<CartItem>{
	CartItem prepareCartitem(CartItem cartItem);
}
