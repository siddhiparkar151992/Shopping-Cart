package com.client.shoppingcart.businessobjects;

public class Category {
	private String name;
	private int id;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [name=" + name + ", id=" + id + "]";
	}
	public Category(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
}
