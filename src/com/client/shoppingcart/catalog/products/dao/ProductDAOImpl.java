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
	
	List<Product> prodList= new ArrayList<Product>();
	public ProductDAOImpl() {
		MongoCursor<Document> cursor= productCollection.find().iterator();
		while(cursor.hasNext()){
			
			Document nextElem = cursor.next();
			
			prodList.add(new Product(nextElem.getString("name"),nextElem.getString("description"),nextElem.getDouble("price"), new Category(nextElem.getString("name"),nextElem.getInteger("categoryId") ),nextElem.getString("id")));
		}
	}
	public List<Product> getProdList() {
		return prodList;
	}
	public void setProdList(List<Product> prodList) {
		this.prodList = prodList;
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


	@Override
	public Product getEntity(Product id) {
		MongoCursor<Document> cursor= productCollection.find().iterator();
		return null;
	}


	@Override
	public Product getEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(Product entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Product entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Product entity) {
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
	
}
