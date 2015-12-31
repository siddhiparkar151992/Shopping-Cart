package com.client.shoppingcart.businessobjects.order;

public class Order {
	private double subTotal;//one time price for items
	private double total;//final price
	public Order(double subTotal, double total) {
		super();
		this.subTotal = subTotal;
		this.total = total;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
