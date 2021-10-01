package com.ebook.model.service;

import com.ebook.dal.PartnerInventory;
import com.ebook.model.item.Product;
import com.ebook.model.partner.Inventory;

public class Partner_Inventory_Ser implements Inventory{
	private PartnerInventory inventory1= new PartnerInventory();

	@Override
	public void addProduct(Product product, int quantity) {
		try{
            inventory1.addProduct(product,quantity);
        }catch (Exception ex){
            System.out.println("Partner inventory service:Threw an error adding a "+product+".");
        }
	}

	@Override
	public void deleteProduct(Product product) {
		try {
			inventory1.deleteProduct(product);
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Threw an error deleting "+ product);
		}
	}

	@Override
	public void increseQuantity(Product product, int amount) {
		try {
			inventory1.increseQuantity(product,amount);
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Threw an error increasing "+ product+" quantity.");
		}
		
	}

	@Override
	public void decreaseQuantity(Product product, int amount) {
		try {
			inventory1.decreaseQuantity(product,amount);
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Threw an error decreasing "+ product+" quantity.");
		}
		
	}

	@Override
	public void reviewAllProducts() {
		try {
			inventory1.reviewAllProducts();
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Threw an error reviwing all partner's products");
		}
		
	}

}
