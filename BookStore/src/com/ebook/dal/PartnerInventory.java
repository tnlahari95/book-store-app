package com.ebook.dal;

import java.util.HashMap;
import java.util.Map;

import com.ebook.model.item.Product;
import com.ebook.model.partner.Inventory;

public class PartnerInventory implements Inventory{
	public PartnerInventory() {
		
	}

    // Integer value keeps track of remain quantity of the product.
    Map <Product,Integer> partnerInventory = new HashMap<>();
    
	@Override
	public void deleteProduct(Product product) {
		partnerInventory.remove(product);
	}
	
	@Override
	// Increase the quantity by amount(amount can be 1 or more)
	public void increseQuantity(Product product, int amount) {
		Integer k = partnerInventory.get(product);
		partnerInventory.put(product,k+amount);
		
	}
	@Override
	public void decreaseQuantity(Product product, int amount) {
		Integer k = partnerInventory.get(product);
		partnerInventory.put(product,k-amount);
	}
	

	@Override
	public void reviewAllProducts() {	
		for (Map.Entry<Product,Integer> list: partnerInventory.entrySet()) {		
			System.out.println(list.getKey() +":"+ list.getValue());
		}
	}
	
	@Override
	public void addProduct(Product product, int quantity) {
		partnerInventory.put(product,quantity);
		
	}
}
