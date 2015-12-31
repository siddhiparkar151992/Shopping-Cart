package com.client.shoppingcart.order.service;

import com.client.shoppingcart.Entity.EntityDao;
import com.client.shoppingcart.businessobjects.order.Order;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.businessobjects.user.User;

public interface OrderService<E> extends EntityDao<E>{
	Order caculateOrderTotal(User user);
	Order calculateShoppingCartTotal(final ShoppingCart cart);
}
