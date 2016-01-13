package com.client.shoppingcart.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.businessobjects.user.User;
import com.client.shoppingcart.cart.dao.CartItemDaoImpl;
import com.client.shoppingcart.cart.service.CartServiceImpl;

@Path("Cart")
public class CartResource {
	ShoppingCart cart = new ShoppingCart();
	CartItemDaoImpl cartDao = new CartItemDaoImpl();
	CartServiceImpl cartService = new CartServiceImpl();

	@POST
	@Path("AddProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProductToCart(CartItem cartItem) {
		cartService.addItem(cartItem);
	}

	@POST
	@Path("GetCart")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ShoppingCart getCart(String id) {
		ShoppingCart cart = cartService.getSHoppingCart(id);
		return cart;

	}

	@POST
	@Path("GetCartItems")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ShoppingCart getCartItems(User user) {
		if (user != null && user.getId() > 0) {
			ShoppingCart cart = cartService.getShoppingCartByUser(user.getId());
			return cart;
		}
		return null;

	}

	@POST
	@Path("GetCartWithProducts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ShoppingCart getCartWithProducts(User user) {
		if (user.getId()>0) {
			ShoppingCart cart = cartService.getShoppingCartWithProductdata(user.getId());
			return cart;
		}
		return null;

	}
}
