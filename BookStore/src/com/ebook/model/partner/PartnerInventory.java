package com.ebook.model.partner;

import com.ebook.dal.PartnerInventoryDAO;
import com.ebook.model.item.Product;

public class PartnerInventory {
	private Product product;
	private int quantity;
	private PartnerInventoryDAO inventoryDAO;
	
	PartnerInventory(){
		this.inventoryDAO = new PartnerInventoryDAO();
		
	}
	
	PartnerInventory(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}

}
