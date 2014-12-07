package com.bookengine.ws.service.workflow;

import java.util.ArrayList;
import java.util.List;

import com.bookengine.ws.Book;
import com.bookengine.ws.Customer;
import com.bookengine.ws.CustomerDAO;
import com.bookengine.ws.service.representation.CustomerRepresentation;

public class CustomerActivity {
	
	private static CustomerDAO customerDao = new CustomerDAO();
	public List<CustomerRepresentation> getCustomers() {
		List<CustomerRepresentation> customerRepresentations = new ArrayList<CustomerRepresentation>();
		
		for (Customer customer : customerDao.getCustomers()) {
			// Create a representation of the customer.
			
			
			CustomerRepresentation customerRepresentation = new CustomerRepresentation();
			customerRepresentation.setCustID(customer.getCustID());
			customerRepresentation.setName(customer.getName());
			customerRepresentation.setAddress(customer.getAddress());
			customerRepresentation.setPhone(customer.getPhone());
			customerRepresentation.setBooks(customer.getBooks());
			
			
			// Add it to the list of Book representations.
			customerRepresentations.add(customerRepresentation);
		}
		
		return customerRepresentations;
	}
	
	public CustomerRepresentation getCustomer(String id) {
		Customer customer = customerDao.getCustomer(id);
		
			CustomerRepresentation customerRepresentation = new CustomerRepresentation();
			customerRepresentation.setCustID(customer.getCustID());
			customerRepresentation.setName(customer.getName());
			customerRepresentation.setAddress(customer.getAddress());
			customerRepresentation.setPhone(customer.getPhone());
			customerRepresentation.setBooks(customer.getBooks());
		
		return customerRepresentation;

          }
	
	public CustomerRepresentation createCustomer(String name, String address, String phone, List<Book> books) 
	 {
         Customer customer = customerDao.addCustomer(name, phone, address, books);

         CustomerRepresentation customerRepresentation = new CustomerRepresentation();
			customerRepresentation.setCustID(customer.getCustID());
			customerRepresentation.setName(customer.getName());
			customerRepresentation.setAddress(customer.getAddress());
			customerRepresentation.setPhone(customer.getPhone());
			customerRepresentation.setBooks(customer.getBooks());
		
		return customerRepresentation;
    }
	
	
	public String authenticate(String username, String password) {
		for (Customer customer : customerDao.getCustomers()) {
			if (customer.getUserName().equals(username) && customer.getPassword().equals(password)) {
				return customer.getCustID();
			}
		}
		return null;
	}
}
