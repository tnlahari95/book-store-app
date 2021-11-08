package com.ebook.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.ebook.model.customer.Address;
import com.ebook.service.customer.representation.customerRequest;
import com.ebook.service.item.representation.ProductRequest;

public class CustomerServiceClient {

	public static void main(String args[]) throws Exception {

	   	 List<Object> providers = new ArrayList<Object>();
	        JacksonJsonProvider provider = new JacksonJsonProvider();
	        provider.addUntouchable(Response.class);
	        providers.add(provider);
	        System.out.println(providers);
	        
	        
	        /*****************************************************************************************
	         * GET METHOD invoke
	         *****************************************************************************************/
	        System.out.println("GET METHOD .........................................................");
	        WebClient getClient = WebClient.create("http://localhost:8080", providers);
	        
	        //Configuring the CXF logging interceptor for the outgoing message
	        WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
	      //Configuring the CXF logging interceptor for the incoming response
	        WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
	        
	        // change application/xml  to get in xml format
	        getClient = getClient.accept("application/json").type("application/json").path("/customerservice/customer/XY1111");
	        
	        //The following lines are to show how to log messages without the CXF interceptors
	        String getRequestURI = getClient.getCurrentURI().toString();
	        System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
	        String getRequestHeaders = getClient.getHeaders().toString();
	        System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);
	        
	        //to see as raw XML/json
//	        String employee = getClient.get();
//	        System.out.println(employee);
//	        System.out.println("Name:" + employee.getFirstName());
//	        System.out.println("privileges:" + employee.getPrivileges());
	        System.out.println(getClient.get());
	        String response = getClient.get(String.class);
	        System.out.println("GET METHOD Response: ...." + response);
	        
	       //to get the response as object of Employee class
	       //Employee employee = client.get(Employee.class);
	       //System.out.println("Name:" + employee.getFirstName());
	       //System.out.println("privileges:" + employee.getPrivileges());
	       
	       /*****************************************************************************************
	        * POST METHOD invoke
	       *****************************************************************************************/
	       System.out.println("POST METHOD .........................................................");
	       WebClient postClient = WebClient.create("http://localhost:8080", providers);
	       WebClient.getConfig(postClient).getOutInterceptors().add(new LoggingOutInterceptor());
	       WebClient.getConfig(postClient).getInInterceptors().add(new LoggingInInterceptor());
	                
	       // change application/xml  to application/json get in json format
	       postClient = postClient.accept("application/xml").type("application/xml").path("/customerservice/customer");
	    	
	       String postRequestURI = postClient.getCurrentURI().toString();
	       System.out.println("Client POST METHOD Request URI:  " + postRequestURI);
	       String postRequestHeaders = postClient.getHeaders().toString();
	       System.out.println("Client POST METHOD Request Headers:  " + postRequestHeaders);
	       customerRequest customerRequest = new customerRequest();
	       customerRequest.setFirstName("Jane");
	       customerRequest.setLastName("Smith");
	       
	       Address billingAddress = new Address();
	        billingAddress.setStreet("500 West Madison St.");
	        billingAddress.setUnit("Suite 1000");
	        billingAddress.setCity("Chicago");
	        billingAddress.setState("IL");
	        billingAddress.setZip("66610");
	        customerRequest.setBillingAddress(billingAddress);
	      
	       Address shippingAddress = new Address();
		    shippingAddress.setStreet("500 West Madison St.");
		    shippingAddress.setUnit("Suite 1000");
		    shippingAddress.setCity("Chicago");
		    shippingAddress.setState("IL");
		    shippingAddress.setZip("66610");
		    customerRequest.setShippingAddress(shippingAddress);
	       
	       
	    	String responsePost =  postClient.post(customerRequest, String.class);
	       System.out.println("POST MEDTHOD Response ........." + responsePost);
	       
	       /*****************************************************************************************
	        * GET METHOD invoke for all customers
	        *****************************************************************************************/
	       System.out.println("GET METHOD for all customers..........................................");
	       WebClient getAllClient = WebClient.create("http://localhost:8080", providers);
	       WebClient.getConfig(getAllClient).getOutInterceptors().add(new LoggingOutInterceptor());
	       WebClient.getConfig(getAllClient).getInInterceptors().add(new LoggingInInterceptor());
	       
	       // change application/xml  to get in xml format
	       getAllClient = getAllClient.accept("application/json").type("application/json").path("/customerservice/customer");
	                
	       String getAllRequestURI = getAllClient.getCurrentURI().toString();
	       System.out.println("Client GET METHOD Request URI:  " + getAllRequestURI);
	       String getAllRequestHeaders = getAllClient.getHeaders().toString();
	       System.out.println("Client GET METHOD Request Headers:  " + getAllRequestHeaders);
	       
	       //to see as raw XML/json
	       String getAllResponse = getAllClient.get(String.class);
	       System.out.println("GET All METHOD Response: ...." + getAllResponse);
	       
	       /*****************************************************************************************
	        * DELETE METHOD invoke
	       *****************************************************************************************/
	       System.out.println("DELETE METHOD .........................................................");
	       WebClient deleteClient = WebClient.create("http://localhost:8080", providers);
	       WebClient.getConfig(deleteClient).getOutInterceptors().add(new LoggingOutInterceptor());
	       WebClient.getConfig(deleteClient).getInInterceptors().add(new LoggingInInterceptor());
	       
	       // change application/xml  to application/json get in json format
	       deleteClient = deleteClient.accept("application/xml").type("application/json").path("/customerservice/customer/XY1111");
	    	
	       String deleteRequestURI = deleteClient.getCurrentURI().toString();
	       System.out.println("Client DELETE METHOD Request URI:  " + deleteRequestURI);
	       String deleteRequestHeaders = deleteClient.getHeaders().toString();
	       System.out.println("Client DELETE METHOD Request Headers:  " + deleteRequestHeaders);
	       
	       deleteClient.delete();
	       System.out.println("DELETE MEDTHOD Response ......... OK");
	        
	       System.exit(0);
	   }
}
