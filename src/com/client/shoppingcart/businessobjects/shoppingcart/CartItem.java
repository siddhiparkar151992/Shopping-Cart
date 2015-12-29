package com.client.shoppingcart.businessobjects.shoppingcart;

import java.math.BigDecimal;

import com.client.shoppingcart.Entity.EntityManagerImpl;
import com.client.shoppingcart.businessobjects.Product;

public class CartItem extends EntityManagerImpl{
	private Long id;
	private Long productId;
	private BigDecimal itemPrice;
	private BigDecimal subTotal;
	private Product product;
	private ShoppingCart cart;
	public CartItem(Product product, ShoppingCart cart) {
		super();
		this.product = product;
		this.cart = cart;
	}
	public CartItem(Product product) {
		super();
		this.product = product;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * @return the itemPrice
	 */
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * @return the subTotal
	 */
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the cart
	 */
	public ShoppingCart getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
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
	
	
}
