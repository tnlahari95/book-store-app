package com.ebook.service.customer.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.customer.CustomerManager;
import com.ebook.model.order.Order;
import com.ebook.service.customer.representation.customerRepresentation;



public class customerActivity {
	
	private static CustomerManager cs = new CustomerManager();

	public Set<customerRepresentation> getAllCustomers() {
		Set<Customer> customers = new HashSet<Customer>();
		Set<customerRepresentation> customerRepresentations = new HashSet<customerRepresentation>();
		customers = cs.getAllCustomers();
		
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
	          Customer c = (Customer)it.next();
	          customerRepresentation customerRepresentation = new customerRepresentation();
	          customerRepresentation.setCustomerId(c.getCustomerId());
	          customerRepresentation.setFirstName(c.getFirstName());
	          customerRepresentation.setLastName(c.getLastName());
	          customerRepresentation.setBillingAddress(c.getBillingAddress());
	          customerRepresentation.setShippingAddress(c.getShippingAddress());
	          customerRepresentation.setOrders(c.getOrders());
	          
	          //now add this representation in the list
	          customerRepresentations.add(customerRepresentation);
	        }
		return customerRepresentations;
	}
	
	public customerRepresentation getCustomerById(String CustomerId) {
		
		Customer customer = cs.getCustomerById(CustomerId);
		
		customerRepresentation cRep = new customerRepresentation();
		cRep.setCustomerId(customer.getCustomerId());
		cRep.setFirstName(customer.getFirstName());
		cRep.setLastName(customer.getLastName());
		cRep.setBillingAddress(customer.getBillingAddress());
		cRep.setShippingAddress(customer.getShippingAddress());
		cRep.setOrders(customer.getOrders());
		
		return cRep;
	}
	
	 public customerRepresentation addCustomer(String FirstName, String LastName, Address BillingAddress, Address ShippingAddress, List<Order> Orders) {
			
			Customer c = cs.addCustomer(FirstName, LastName, BillingAddress, ShippingAddress, Orders);
			
			customerRepresentation cRep = new customerRepresentation();
			cRep.setCustomerId(c.getCustomerId());
			cRep.setFirstName(c.getFirstName());
			cRep.setLastName(c.getLastName());
			cRep.setBillingAddress(c.getBillingAddress());
			cRep.setShippingAddress(c.getShippingAddress());
			cRep.setOrders(c.getOrders());
			
			return cRep;

	}
	 
	 public String removeCustomer(String CustomerId) {
			cs.removeCustomer(CustomerId);	
			
			return "Ok";
	}
		
	
}
