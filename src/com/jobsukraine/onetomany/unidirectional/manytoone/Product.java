package com.jobsukraine.onetomany.unidirectional.manytoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id @GeneratedValue
	private long id;
	
	private String type;
	
	private String name;
	
	private long price;

	public Product() {
	
	}
	
	public Product(String type, String name, long price, Category category) {
		super();
		this.type = type;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	@ManyToOne
	private Category category;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", type=" + type + ", name=" + name + ", price=" + price + ", category=" + category
				+ "]\n";
	}
	
	
	
}
