package com.client.shoppingcart.catalog.products.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.client.shoppingcart.businessobjects.Category;
import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.databaseconnection.DatabaseConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class ProductDAOImpl implements ProductDAO{
	static MongoCollection<Document> productCollection = DatabaseConnection.getConnection().getCollection("products");
	
	@Override
	public Object getEntity(Class className, Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void save(Object entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Product> getById() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> getByProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		System.out.println("inside getAllProducts");
		MongoCursor<Document> cursor= productCollection.find().iterator();
		while(cursor.hasNext()){
			
			Document nextElem = cursor.next();
			
			products.add(new Product(nextElem.getString("name"),nextElem.getString("description"),nextElem.getDouble("price"), new Category(nextElem.getString("name"),nextElem.getInteger("categoryId") ),nextElem.getString("id")));
		}
		return products;
		
	}
	
}
