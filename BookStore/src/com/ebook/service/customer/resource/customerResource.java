package com.ebook.service.customer.resource;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ebook.model.customer.Customer;
import com.ebook.service.customer.representation.customerRepresentation;
import com.ebook.service.customer.representation.customerRequest;
import com.ebook.service.customer.workflow.customerActivity;
import com.ebook.service.item.representation.ProductRepresentation;
import com.ebook.service.item.representation.ProductRequest;
import com.ebook.service.item.workflow.ProductActivity;

@Path("/customerservice/")
public class customerResource implements customerService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public Set<customerRepresentation> getAllCustomers() {
		System.out.println("GET METHOD Request for all Customers .............");
		customerActivity cActivity = new customerActivity();
		return cActivity.getAllCustomers();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{CustomerId}")
	public customerRepresentation getCustomerById(String CustomerId) {
		System.out.println("GET METHOD Request from Client with CustomerRequest String ............." + CustomerId);
		customerActivity cActivity = new customerActivity();
		return cActivity.getCustomerById(CustomerId);
	}
	
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public customerRepresentation addCustomer(customerRequest  customerRequest) {
		System.out.println("POST METHOD Request from Client with ............." + customerRequest.getFirstName() + "  " + customerRequest.getLastName() + " " + customerRequest.getBillingAddress() + " " + customerRequest.getBillingAddress() + " " + customerRequest.getShippingAddress() + " " + customerRequest.getOrders());
		customerActivity cActivity = new customerActivity();
		return cActivity.addCustomer(customerRequest.getFirstName(),customerRequest.getLastName(),customerRequest.getBillingAddress(),customerRequest.getShippingAddress(), customerRequest.getOrders());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{CustomerId}")
	public Response removeCustomer(@PathParam("CustomerId") String CustomerId) {
		System.out.println("Delete METHOD Request from Client with CustomerRequest String ............." + CustomerId);
		customerActivity cActivity = new customerActivity();
		String res = cActivity.removeCustomer(CustomerId);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	


}
