package com.ebook.service.customer.representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.customer.Address;
import com.ebook.model.order.Order;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class customerRepresentation {
		
	private String customerId;
	private String lastName;
	private String firstName;
	private Address billingAddress;
	private Address shippingAddress;
	private List<Order> orders = new ArrayList<Order>();
	
	public customerRepresentation() {}
			
		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String id) {
			this.customerId = id;
		}
		
		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public Address getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(Address billingAddress) {
			this.billingAddress = billingAddress;
		}

		public Address getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(Address shippingAddress) {
			this.shippingAddress = shippingAddress;			
		}
		
		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
		
		public void addOrder(Order order) {
			orders.add(order);
		}



}
