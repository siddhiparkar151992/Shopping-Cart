package com.client.shoppingcart.cart.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import org.bson.Document;

import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.cart.service.CartService;
import com.client.shoppingcart.databaseconnection.DatabaseConnection;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class CartDaoImpl implements CartDAO{
	CartService cartService;
	CartItemDaoImpl cartitemDaoImpl;
	MongoCollection<Document> cartCollection = DatabaseConnection
			.getConnection().getCollection("cart");
	@Override
	public ShoppingCart getEntity(ShoppingCart id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart getEntityById(Object id) {
		ShoppingCart cart = null;
		BasicDBObject whereQuery = new BasicDBObject();
		Set<CartItem> cartItems= new HashSet<CartItem>();
		MongoCursor<Document> cursor= cartCollection.find().iterator();
		while(cursor.hasNext()){
			Document nextElem = cursor.next();
			if(nextElem.getString("cart_id").equals("id")){
				cart.setcartId(id.toString());
				BasicDBList e = (BasicDBList) nextElem.get("cartItems");
				for(int i=0;i<e.size();i++){
					cartItems.add((CartItem) e.get(i));
				}
				cart.setCartItems(cartItems);
				cart.setCustomerID(nextElem.getInteger("customerId"));
			}
		}
		return cart;
	}

	@Override
	public void save(ShoppingCart cart,CartItem cartItem) {
		CartItem item =cartitemDaoImpl.prepareCartitem(cartItem);
		Document newDOcument = new Document();
		cart.getCartItems().add(item);
		newDOcument.put("CartItems",cart.getCartItems());
		BasicDBObject searchQuery=new BasicDBObject().append("cart_id", cart.getCartId());
		cartCollection.replaceOne(searchQuery, newDOcument);
	}

	@Override
	public void update(ShoppingCart entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ShoppingCart entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(ShoppingCart entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShoppingCart getShoppingCartByUser(int id) {
		ShoppingCart cart = new ShoppingCart();
		BasicDBObject whereQuery = new BasicDBObject();
		Set<CartItem> cartItems= new HashSet<CartItem>();
		MongoCursor<Document> cursor= cartCollection.find().iterator();
		while(cursor.hasNext()){
			Document nextElem = cursor.next();
			if(nextElem.getInteger("customerId")==id){
				cart.setcartId(nextElem.getString("cart_id"));
				BasicDBList e = (BasicDBList) nextElem.get("cart_items");
				ArrayList listInsertions = (ArrayList)nextElem.get("cartItems");
				for(int i=0;i<listInsertions.size();i++){
					Document listItem= (Document) listInsertions.get(i);
					cartItems.add(new CartItem(listItem.getLong("cart_item_id"), nextElem.getString("cart_id"), listItem.getInteger("quantity"), listItem.getString("ProductId"), listItem.getDouble("itemPrice"), listItem.getDouble("subTotal")));
				}
				cart.setCartItems(cartItems);
				cart.setCustomerID(nextElem.getInteger("customerId"));
			}
		}
		return cart;
	}

	@Override
	public void addItem(CartItem item) {
		ShoppingCart cart = new ShoppingCart();
		Set<CartItem> cartItems= new HashSet<CartItem>();
		MongoCursor<Document> cursor= cartCollection.find().iterator();
		while(cursor.hasNext()){
			Document nextElem = cursor.next();
			if(nextElem.getString("cart_id")==item.getShoppingCartId()){
				cart.setcartId(nextElem.getString("cart_id"));
				BasicDBList e = (BasicDBList) nextElem.get("cart_items");
				ArrayList listInsertions = (ArrayList)nextElem.get("cartItems");
				for(int i=0;i<listInsertions.size();i++){
					Document listItem= (Document) listInsertions.get(i);
					if(listItem.getString("ProductId").equals(item.getProductId())){
						cartItems.add(new CartItem(listItem.getLong("cart_item_id"), nextElem.getString("cart_id"), listItem.getInteger("quantity")+1, listItem.getString("ProductId"), listItem.getDouble("itemPrice"), listItem.getDouble("subTotal")));
					}
					else{
						cartItems.add(new CartItem(listItem.getLong("cart_item_id"), nextElem.getString("cart_id"), listItem.getInteger("quantity"), listItem.getString("ProductId"), listItem.getDouble("itemPrice"), listItem.getDouble("subTotal")));
						
					}
					}
				cart.setCartItems(cartItems);
				cart.setCustomerID(nextElem.getInteger("customerId"));
			}
		}
		
	}



}
