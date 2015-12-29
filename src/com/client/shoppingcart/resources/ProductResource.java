package com.client.shoppingcart.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.catalog.products.dao.ProductDAO;
import com.client.shoppingcart.catalog.products.dao.ProductDAOImpl;

@Path("Products")
public class ProductResource {
	ProductDAOImpl productDao= new ProductDAOImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts(){
		List<Product> products= productDao.getAllProducts();
		return products;
		
	}
	
	@POST
	@Path("AddProduct")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProductToCart(Product product){
		
	}
}
