package com.ebook.model.item;

import java.util.Set;

public interface IProductManager {
	
	public Set<Product> getAllProducts();
	
	public Product getProductById(String productId);
	
	public Product AddProduct(String prodTitle, String prodDesc, double prodprice, String prodAuthor);
	
	public void UpdateProduct(String productId, String prodTitle, String prodDesc, double prodprice, String prodAuthor);
	
	
	//public void Add(Object object);
	
	//public void Update(Object object);
	
	//public void remove(Object object);
	
	//public void getAll();
	
	//public void getById(Object objectid);
}
