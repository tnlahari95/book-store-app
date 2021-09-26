package com.ebook.model.item;

import java.util.List;

public class Product {
	private String id;
	private String title;
	private double price;
	private String description;
	private List<Review> review;
	
	public Product() {}
	
	public Product(String id, String title, double price, String description, List<Review> review) {
		this.id=id;
		this.title=title;
		this.price=price;
		this.description=description;
		this.review=review;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Review> getReview() {
		return review;
	}
	
	public void setReview(List<Review> review) {
		this.review = review;
	}
}
