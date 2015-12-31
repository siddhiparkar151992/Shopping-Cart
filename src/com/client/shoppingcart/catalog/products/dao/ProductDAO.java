package com.client.shoppingcart.catalog.products.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.Document;

import com.client.shoppingcart.Entity.EntityDao;
import com.client.shoppingcart.businessobjects.Category;
import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.databaseconnection.DatabaseConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public interface ProductDAO extends EntityDao<Product>{

	List<Product> getById();

	List<Product> getByProduct(Product product);
	
	List<Product> getAllProducts();

}
