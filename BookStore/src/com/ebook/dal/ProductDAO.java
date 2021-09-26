package com.ebook.dal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ebook.model.item.Product;

public class ProductDAO {
private static HashMap <String, Product> products = new HashMap <String, Product>();
	
	public ProductDAO() {		
	}
	
	public Product getProductById(String productId) {
		return products.get(productId);
	}
	
	public void AddProduct(Product product) {
		Product prod = new Product();
		prod.setId(product.getId());
		products.put(prod.getId(), prod);
	}
	
	public void UpdateProduct(Product product) {		
		Set keys = products.keySet();
		Iterator i = keys.iterator();
	      while (i.hasNext()) {
	    	 String productId = (String) i.next();
	         if(productId == product.getId())
	         {
	        	 products.put(productId, product);
	         }
	      }
	}

	public List<Product> getAllProducts() {
		return (List<Product>) products.values(); 
	}

	public boolean removeProduct(Product product) {
		Product prod = new Product();
		prod.setId(product.getId());
		return products.remove(prod.getId(), prod);
	}

}
