package com.ebook.dal;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Book;
import com.ebook.model.order.IFacade;
import com.ebook.model.order.Order;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.OrderFacadeImpl;
import com.ebook.model.order.Payment;

public class CustomerDAO {
	
	private static HashMap <String, Order> orders = new HashMap <String, Order>();
	
	private static Set<Customer> Customers = new HashSet<Customer>();
	
	public CustomerDAO() {
		
		Customer customer = new Customer();
	    
		customer.setCustomerId("XY1111");
		customer.setFirstName("John");
		customer.setLastName("Smith");
		
		Address billingAddress = new Address();
	        billingAddress.setStreet("500 West Madison St.");
	        billingAddress.setUnit("Suite 1000");
	        billingAddress.setCity("Chicago");
	        billingAddress.setState("IL");
	        billingAddress.setZip("66610");
	        customer.setBillingAddress(billingAddress);
	        
	    Address shippingAddress = new Address();
	    	shippingAddress.setStreet("500 West Madison St.");
	    	shippingAddress.setUnit("Suite 1000");
	    	shippingAddress.setCity("Chicago");
	    	shippingAddress.setState("IL");
	    	shippingAddress.setZip("66610");
	        customer.setShippingAddress(shippingAddress);
			
	        
	    Order order1 = new Order();
	        order1. setOrderId("BO-66734");
	        order1.setOrderState("Completed");	        
	        customer.addOrder(order1);
	        
 //order detail contains products ordered
	        
	        //First product
	        Book product1 = new Book();
	        product1.setproductId("BF-7898");
	        //product1.setISBN("234-89675-27690");
	        product1.setTitle("Patterns of Enterprise Application Architecture");
	        product1.setAuthor("Folwer, Martin");
	        product1.setPrice(50.99);
	        
	        //Add product to order
	        order1.addProduct(product1, 1);
	        
	        //Second product
	        Book product2 = new Book();
	        product2.setproductId("BF-2345");
	        product2.setISBN("892-12345-93667");
	        product2.setTitle("Web Application Architecture");
	        product2.setAuthor("Shklar, Leon");
	        product2.setPrice(45.99);
	        
	        //Add the products detail to Order
	        order1.addProduct(product2, 1);
	 
	        //Confirm order
	        order1.confirmOrder();
		       
	        Payment payment = new Payment();
	        payment.setPaymentId(new Long("1234"));
	        payment.setPaymentStatus("Paid");
	        payment.setPaymentType("CreditCard");
	        payment.setSubTotal(order1.getOrderTotal());
	        
	        order1.setPayment(payment);
	 	        
	        order1.orderPayed();
	        
//	        //finish order	        
//	        order1.confirmOrder();
//	        order1.orderPayed();
	        
	         
	        IFacade facade = new OrderFacadeImpl();
	        facade.create(order1);
	        Order orderCache = (Order) facade.get(order1.getOrderId());
	        
	        System.out.println("get order or order details: "+orderCache );
	        
	        // NOTE: To cancel the request, un-comment the following line.
	        
	        //order.cancel();
	        
	        // Then, comment out the next 2 lines.
	        order1.orderSendOut();
	        facade.update(order1.getOrderId(), order1.getOrderState());
	        order1.orderDelivered();
	        facade.update(order1.getOrderId(), order1.getOrderState());
	      
	        
	        // Print out an order summary
	        Address billingAdd = customer.getBillingAddress();
	        List<OrderDetail> orderLines = orderCache.getOrderDetails();
	        double orderTotal = orderCache.getOrderTotal();

	        // Format order output
	        System.out.println("\tOrder Id: \t\t" + orderCache.getOrderId() + "\n");
	        System.out.println("\tOrder status: \t\t" + orderCache.getOrderState() + "\n");
	        System.out.println("\tName: \t\t\t" + customer.getFirstName() + " " + customer.getLastName() + "\n");

	        System.out.println("\tBilling Address:\t" + billingAdd.getStreet() + 
	        		"\n\t\t\t\t" + billingAdd.getUnit() + 
	        		"\n\t\t\t\t" + billingAdd.getCity() + ", " + 
	        		billingAdd.getState() + " " + billingAdd.getZip() +
	        		"\n");

	        System.out.println("\tOrder Items: ");
	        for (OrderDetail line : orderLines) {
	        	System.out.println("\t\t\t\t" + line.getProduct().getTitle() + "\t" + 
	        			line.getProduct().getPrice() + " x " + line.getQuantity());
	        }

	        System.out.println("\n\tOrder Total:\t\t" + orderTotal);
	        
	        
	        System.out.println("\n\tPayment ID:\t\t" + orderCache.getPayment().getPaymentId());
	        System.out.println("\n\tPayment Type:\t\t" + orderCache.getPayment().getPaymentType());
	        System.out.println("\n\tPayment Status:\t\t" + orderCache.getPayment().getPaymentStatus());

	}
	
	
	public Set<Customer> getAllCustomers(){
		return Customers;
		
	}
	
	public Customer getCustomerById(String customerId) {
		Iterator<Customer> it = Customers.iterator();
		while(it.hasNext()) {
          Customer customer = (Customer)it.next();
          if (customer.getCustomerId().equals(customerId)) {
        	  return customer;
          }
        }
		return null;
	}
	
	public Customer addCustomer(String FirstName, String LastName, Address BillingAddress, Address ShippingAddress, List<Order> Orders){
		
		Customer cust = new Customer();
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    long randomLong = randomGenerator.nextLong();
	    String CustomerId = "XY" + randomInt;
	    
		cust.setCustomerId(cust.getCustomerId());
		cust.setFirstName(cust.getFirstName());
		cust.setLastName(cust.getLastName());
		cust.setBillingAddress(cust.getBillingAddress());
		cust.setShippingAddress(cust.getShippingAddress());
		cust.setOrders(cust.getOrders());
		
		Customers.add(cust);
		
		return cust;	
	}
	
	public void updateCustomer(String CustomerId, String FirstName, String LastName, Address BillingAddress, Address ShippingAddress, List<Order> Orders) {		
		/*Set keys = Customers.keySet();
		Iterator i = keys.iterator();
	      while (i.hasNext()) {
	    	 String CustomerId = (String) i.next();
	         if(CustomerId == customer.getCustomerId())
	         {
	        	 Customers.put(CustomerId, customer);
	         }
	      }*/
	      
	      Iterator<Customer> it = Customers.iterator();
			while(it.hasNext()) {
	          Customer c = (Customer)it.next();
	          if (c.getCustomerId().equals(CustomerId)) {
	        	c.setFirstName(c.getFirstName());
	      		c.setLastName(c.getLastName());
	      		c.setBillingAddress(c.getBillingAddress());
	      		c.setShippingAddress(c.getShippingAddress());
	      		c.setOrders(c.getOrders());
	        	  return;
	          }
			}
	}
	
	public void removeCustomer(String CustomerId) {
		/*Customer cust = new Customer();
		cust.setCustomerId(customer.getCustomerId());
		return Customers.remove(cust.getCustomerId(), cust);
	}*/
		Iterator<Customer> it = Customers.iterator();
		while(it.hasNext()) {
          Customer c = (Customer)it.next();
          if (c.getCustomerId().equals(CustomerId)) {
        	  Customers.remove(c);
        	  return;
          }
        }
	}
}

/*---------------------------------------------------------------------------------------*/
	
	/*public Customer getCustomer(String customerId) {
		 	 
	    try { 		
	    	//Get Customer
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectCustomerQuery = "SELECT customerID, lname, fname FROM Customer WHERE customerID = '" + customerId + "'";

	    	ResultSet custRS = st.executeQuery(selectCustomerQuery);      
	    	System.out.println("CustomerDAO: *************** Query " + selectCustomerQuery);
	    	
	      //Get Customer
    	  Customer customer = new Customer();
	      while ( custRS.next() ) {
	    	  customer.setCustomerId(custRS.getString("customerID"));
	    	  customer.setLastName(custRS.getString("lname"));
	    	  customer.setFirstName(custRS.getString("fname"));
	      }
	      //close to manage resources
	      custRS.close();
	      	    		  
	      //Get Address
	      String selectAddressQuery = "SELECT addressID, street, unit, city, state, zip FROM Address WHERE customerID = '" + customerId + "'";
	      ResultSet addRS = st.executeQuery(selectAddressQuery);
    	  Address address = new Address();
    	  
    	  System.out.println("CustomerDAO: *************** Query " + selectAddressQuery);
    	  
	      while ( addRS.next() ) {
	    	  address.setAddressId(addRS.getString("addressid"));
	    	  address.setStreet(addRS.getString("street"));
	    	  address.setUnit(addRS.getString("unit"));
	    	  address.setCity(addRS.getString("city"));
	    	  address.setState(addRS.getString("state"));
	    	  address.setZip(addRS.getString("zip"));
	      }
	      
	      customer.setBillingAddress(address);
	      //close to manage resources
	      addRS.close();
	      st.close();
	      
	      return customer;
	    }	    
	    catch (SQLException se) {
	      System.err.println("CustomerDAO: Threw a SQLException retrieving the customer object.");
	      System.err.println(se.getMessage());
	      se.printStackTrace();
	    }
	    
	    return null;
	  }*/
	
	/*public void addCustomer(Customer cust) {
		Connection con = DBHelper.getConnection();
        PreparedStatement custPst = null;
        PreparedStatement addPst = null;

        try {
        	//Insert the customer object
            String custStm = "INSERT INTO Customer(customerID, lname, fname) VALUES(?, ?, ?)";
            custPst = con.prepareStatement(custStm);
            custPst.setString(1, cust.getCustomerId());
            custPst.setString(2, cust.getLastName());       
            custPst.setString(3, cust.getFirstName()); 
            custPst.executeUpdate();

        	//Insert the customer address object
            String addStm = "INSERT INTO Address(customerID, addressID, street, unit, city, state, zip) VALUES(?, ?, ?, ?, ?, ?, ?)";
            addPst = con.prepareStatement(addStm);
            addPst.setString(1, cust.getCustomerId());
            addPst.setString(2, cust.getBillingAddress().getAddressId());  
            addPst.setString(3, cust.getBillingAddress().getStreet());       
            addPst.setString(4, cust.getBillingAddress().getUnit());  
            addPst.setString(5, cust.getBillingAddress().getCity());  
            addPst.setString(6, cust.getBillingAddress().getState());      
            addPst.setString(7, cust.getBillingAddress().getZip());  
            addPst.executeUpdate();
        } catch (SQLException ex) {

        } finally {

            try {
                if (addPst != null) {
                	addPst.close();
                	custPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("CustomerDAO: Threw a SQLException saving the customer object.");
    	      System.err.println(ex.getMessage());
            }
        }
    }*/

