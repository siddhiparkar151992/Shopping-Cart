package com.client.shoppingcart.cart.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.client.shoppingcart.businessobjects.Product;
import com.client.shoppingcart.businessobjects.shoppingcart.CartItem;
import com.client.shoppingcart.businessobjects.shoppingcart.ShoppingCart;
import com.client.shoppingcart.cart.service.CartService;
import com.client.shoppingcart.catalog.products.dao.ProductDAOImpl;
import com.client.shoppingcart.databaseconnection.DatabaseConnection;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class CartDaoImpl implements CartDAO {
	CartService cartService;
	CartItemDaoImpl cartitemDaoImpl = new CartItemDaoImpl();
	ProductDAOImpl productDaoImpl = new ProductDAOImpl();
	MongoCollection<Document> cartCollection = DatabaseConnection
			.getConnection().getCollection("cart");

	MongoCollection<Document> productColl = DatabaseConnection.getConnection()
			.getCollection("products");

	@Override
	public ShoppingCart getEntity(ShoppingCart id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart getEntityById(Object id) {
		ShoppingCart cart = new ShoppingCart();
		BasicDBObject whereQuery = new BasicDBObject();
		Set<CartItem> cartItems = new HashSet<CartItem>();
		MongoCursor<Document> cursor = cartCollection.find().iterator();
		while (cursor.hasNext()) {
			Document nextElem = cursor.next();
			if (nextElem.getString("cart_id").equals(id)) {
				cart.setcartId(id.toString());
				ArrayList itemList = (ArrayList) nextElem.get("cartItems");
				for (int i = 0; i < itemList.size(); i++) {
					Document listItem = (Document) itemList.get(i);
					cartItems.add(new CartItem(
							listItem.getLong("cart_item_id"), nextElem
									.getString("cart_id"), listItem
									.getInteger("quantity"), listItem
									.getString("productId"), listItem
									.getDouble("itemPrice"), listItem
									.getDouble("subTotal")));
				}
				cart.setCartItems(cartItems);
				cart.setCustomerID(nextElem.getInteger("customerId"));
			}
		}
		return cart;
	}

	@Override
	public void save(ShoppingCart cart, CartItem cartItem) {
		Document newDOcument = new Document();
		List<CartItem> list = new ArrayList<CartItem>(cart.getCartItems());
		List<Document> documentList = new ArrayList<Document>();
		for (int i = 0; i < list.size(); i++) {
			documentList.add(new Document()
					.append("cart_item_id", list.get(i).getId())
					.append("quantity", new Integer(list.get(i).getQuantity()))
					.append("itemPrice", list.get(i).getItemPrice())
					.append("subTotal", list.get(i).getSubTotal())
					.append("finalPrice", list.get(i).getSubTotal())
					.append("productId", list.get(i).getProductId()));
		}
		newDOcument.put("cartItems", documentList);
		newDOcument.put("cart_id", cart.getcartId());
		newDOcument.put("customerId", cart.getCustomerID());
		BasicDBObject searchQuery = new BasicDBObject().append("cart_id",
				cart.getCartId());
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
		Set<CartItem> cartItems = new HashSet<CartItem>();
		MongoCursor<Document> cursor = cartCollection.find().iterator();
		while (cursor.hasNext()) {
			Document nextElem = cursor.next();
			if (nextElem.getInteger("customerId") == id) {
				cart.setcartId(nextElem.getString("cart_id"));
				ArrayList listInsertions = (ArrayList) nextElem
						.get("cartItems");
				for (int i = 0; i < listInsertions.size(); i++) {
					Document listItem = (Document) listInsertions.get(i);
					cartItems.add(new CartItem(
							listItem.getLong("cart_item_id"), nextElem
									.getString("cart_id"), listItem.getInteger(
									"quantity").intValue(), listItem
									.getString("ProductId"), listItem
									.getDouble("itemPrice"), listItem
									.getDouble("subTotal")));
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
		Set<CartItem> cartItems = new HashSet<CartItem>();

		BasicDBObject query = new BasicDBObject();
		query.put("cart_id", item.getShoppingCartId());
		MongoCursor<Document> cursor = cartCollection.find(query).iterator();
		cart = getEntityById(item.getShoppingCartId());
		while (cursor.hasNext()) {
			Document nextElem = cursor.next();
			Boolean cartItemExist = false;
			cart.setcartId(nextElem.getString("cart_id"));
			ArrayList listInsertions = (ArrayList) nextElem.get("cartItems");
			for (int i = 0; i < listInsertions.size(); i++) {
				Document listItem = (Document) listInsertions.get(i);
				Integer quantity = new Integer(listItem.getInteger("quantity"));
				if (listItem.getString("productId").equals(item.getProductId())) {
					quantity = quantity + 1;
					cartItemExist = true;
				}
				cartItems.add(new CartItem(listItem.getLong("cart_item_id"),
						nextElem.getString("cart_id"), quantity, listItem
								.getString("productId"), listItem
								.getDouble("itemPrice"), listItem
								.getDouble("subTotal")));

			}
			if (!cartItemExist) {
				CartItem newItem = cartitemDaoImpl.prepareCartitem(item);
				cartItems.add(new CartItem(newItem.getId(), nextElem
						.getString("cart_id"), item.getQuantity(), item
						.getProductId(), item.getItemPrice(), newItem
						.getSubTotal()));
			}

			cart.setCartItems(cartItems);
			cart.setCustomerID(nextElem.getInteger("customerId"));
			save(cart, item);
		}

	}

	@Override
	public ShoppingCart getShoppingCartWithProductdata(int id) {
		ShoppingCart cart = new ShoppingCart();
		BasicDBObject whereQuery = new BasicDBObject();
		Set<CartItem> cartItems = new HashSet<CartItem>();
		MongoCursor<Document> cursor = cartCollection.find().iterator();
		while (cursor.hasNext()) {
			Document nextElem = cursor.next();
			if (nextElem.getInteger("customerId") == id) {
				cart.setcartId(nextElem.getString("cart_id"));
				ArrayList listInsertions = (ArrayList) nextElem
						.get("cartItems");
				for (int i = 0; i < listInsertions.size(); i++) {
					Document listItem = (Document) listInsertions.get(i);
					List<Product> prodList= productDaoImpl.getProdList();
					Product matchedProduct=null;
					for (Product product:prodList) {
						if(product.getId().equals(listItem
								.getString("productId"))){
							matchedProduct = product;
						}
						
					}
					cartItems.add(new CartItem(
							listItem.getLong("cart_item_id"), nextElem
									.getString("cart_id"), listItem.getInteger(
									"quantity").intValue(), listItem
									.getString("productId"), listItem
									.getDouble("itemPrice"), listItem
									.getDouble("subTotal"),matchedProduct));
				}
				cart.setCartItems(cartItems);
				cart.setCustomerID(nextElem.getInteger("customerId"));
			}
		}
		return cart;
	}

}
