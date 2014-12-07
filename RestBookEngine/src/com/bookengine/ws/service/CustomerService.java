package com.bookengine.ws.service;

import java.util.List;

import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.representation.CustomerRepresentation;
import com.bookengine.ws.service.representation.CustomerRequest;



public interface CustomerService {

	public List<CustomerRepresentation> getCustomers();
	public BookRepresentation getCustomer(String id);
	public BookRepresentation createCustomer(CustomerRequest customerRequest);
}
