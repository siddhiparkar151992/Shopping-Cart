package com.client.shoppingcart.businessobjects;

public class Product {
	private String name;
	private String description;
	private double price;
	private Category category;
	/**
	 * @param name
	 * @param description
	 * @param price
	 * @param category
	 * @param id
	 */
	public Product(String name, String description, double price,
			Category category, String id) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.id = id;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	private  String id;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param name
	 * @param description
	 * @param price
	 * @param id
	 */
	public Product(String name, String description, double price, String id) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.id = id;
	}
	
}
