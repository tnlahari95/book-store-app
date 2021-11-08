<<<<<<< HEAD
package com.ebook.model.partner;

import java.util.HashMap;
import java.util.Map;

import com.ebook.model.item.Product;

public class PartnerInventory{

    // Integer value is for keeping track of remain quantity of the product.
    Map <Product,Integer> partnerIntentory = new HashMap<>();

    public void addProduct(Product product, int quantity) {

    }




}
=======
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
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PartnerInventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(PartnerInventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	
	
	PartnerInventory(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}

}
>>>>>>> 04120a596ac7707a16f45a1d1a4283a9147cf0c9
