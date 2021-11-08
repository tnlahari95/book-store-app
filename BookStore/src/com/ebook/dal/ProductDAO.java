package com.ebook.dal;

//import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.List;
import java.util.Random;
import java.util.Set;

import com.ebook.model.item.Product;

public class ProductDAO {
// private static HashMap <String, Product> products = new HashMap <String, Product>();
   private static Set<Product> products = new HashSet<Product>();
	
	public ProductDAO() {
			Product product = new Product();
		    
			product.setproductId("XY1111");
			product.setTitle("Mocking Jay");
			product.setDescription("Book on Mocking Jay");
			product.setPrice(2350);
			product.setAuthor("John Smith");
		
			products.add(product);
		/*--------------------------------------------*/	
			Product product2 = new Product();
			product2.setproductId("XY1112");
			product2.setTitle("Mocking Jay Part 2");
			product2.setDescription("Series book on Mocking Jay");
			product2.setPrice(2353);
			product.setAuthor("John Smith");
		
			products.add(product2);
		
	}
	
	public Set<Product> getAllProducts(){
		return products;
	}
	
	public Product getProductById(String productId) {
		//return products.get(productId);
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product prod = (Product)it.next();
          if (prod.getproductId().equals(productId)) {
        	  return prod;
          }
        }
		return null;
	}
	
	//was void before and remove return
	public Product AddProduct(String prodTitle, String prodDesc, double prodprice, String prodAuthor) {
//		Product prod = new Product();
//		prod.setproductId(product.getproductId());
//		return products.put(prod.getproductId(), prod);
		
        Product product = new Product();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    long randomLong = randomGenerator.nextLong();
	    String productId = "XY" + randomInt;
	    
	    product.setproductId(productId);
	    product.setTitle(prodTitle);
		product.setDescription(prodDesc);
		product.setPrice(prodprice);
		product.setAuthor(prodAuthor);
	
		products.add(product);
		
		return product;
	}
	
	public void UpdateProduct(String productId, String prodTitle, String prodDesc, double prodprice, String prodAuthor) {		
	/*	Set keys = products.keySet();
		Iterator i = keys.iterator();
	      while (i.hasNext()) {
	    	 String productId = (String) i.next();
	         if(productId == product.getproductId())
	         {
	        	 products.put(productId, product);
	         }
	      }
	}*/
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product p = (Product)it.next();
          if (p.getproductId().equals(productId)) {
        	  p.setTitle(prodTitle);
        	  p.setDescription(prodDesc);
        	  p.setPrice(prodprice);
        	  p.setAuthor(prodAuthor);
        	  return;
          }
        }
	}

	/*public List<Product> getAllProducts() {
		return (List<Product>) products.values(); 
	}*/

	public void removeProduct(String productId) {
		/*Product prod = new Product();
		prod.setproductId(product.getproductId());
		return products.remove(prod.getproductId(), prod);*/
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product p = (Product)it.next();
          if (p.getproductId().equals(productId)) {
        	  products.remove(p);
        	  return;
          }
        }
	}
	
}
