package com.ebook.service.customer.resource;

import java.util.Set;

import javax.jws.WebService;

//import com.ebook.model.customer.Customer;
import com.ebook.service.customer.representation.customerRepresentation;
import com.ebook.service.customer.representation.customerRequest;

@WebService
public interface customerService {

	public Set<customerRepresentation> getAllCustomers();
	public customerRepresentation getCustomerById(String CustomerId);
	public customerRepresentation addCustomer(customerRequest customerRequest);
}
