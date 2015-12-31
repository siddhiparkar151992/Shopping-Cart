package com.client.shoppingcart.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.client.shoppingcart.businessobjects.Product;

@Path("Cart")
public class CartResource {
	@POST
	@Path("AddProduct")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProductToCart(Product product){
		
	}
}
