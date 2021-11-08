package com.ebook.model.customer;

import java.util.List;
import java.util.Set;

import com.ebook.dal.CustomerDAO;
import com.ebook.model.order.Order;


public class CustomerManager {
	
	private CustomerDAO custDAO = new CustomerDAO();
		
	public Set<Customer> getAllCustomers(){
		return custDAO.getAllCustomers();
	}
	
	public Customer getCustomerById(String CustomerId){
        
        return custDAO.getCustomerById(CustomerId);     
	}

	public Customer addCustomer(String FirstName, String LastName, Address BillingAddress, Address ShippingAddress, List<Order> Orders) {		
		return custDAO.addCustomer(FirstName, LastName, BillingAddress, ShippingAddress, Orders);
	}
	
	public void updateCustomer(String CustomerId, String FirstName, String LastName, Address BillingAddress, Address ShippingAddress, List<Order> Orders){
	
		custDAO.updateCustomer(CustomerId, FirstName, LastName, BillingAddress, ShippingAddress, Orders);
	
	}
	
	public void removeCustomer(String CustomerId) {
		custDAO.removeCustomer(CustomerId);
	}
	
}
