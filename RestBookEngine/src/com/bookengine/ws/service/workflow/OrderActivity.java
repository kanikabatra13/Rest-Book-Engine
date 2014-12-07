package com.bookengine.ws.service.workflow;

import java.util.ArrayList;
import java.util.List;

import com.bookengine.ws.Book;
import com.bookengine.ws.BookDAO;
import com.bookengine.ws.Customer;
import com.bookengine.ws.CustomerDAO;
import com.bookengine.ws.Order;
import com.bookengine.ws.OrderDAO;
import com.bookengine.ws.service.representation.OrderRepresentation;




public class OrderActivity {
	
	private static final String String = null;
	private static OrderDAO orderdao = new OrderDAO();
	private static CustomerDAO customerDao = new CustomerDAO();
	private static BookDAO bookDao = new BookDAO();
	
	
	
	public OrderRepresentation getOrder(String orderID, String customerId)
	{
	
       // String status = orderdao.getOrderStatus(orderID);
        Order order = orderdao.getCustomerOrder(orderID, customerId);
		
        OrderRepresentation orderRepresentation = new OrderRepresentation();
        orderRepresentation.setOrderID(order.getOrderID());
        orderRepresentation.setStatus(order.getStatus());
        orderRepresentation.setCustomer(order.getCustomer());
        orderRepresentation.setBooks(order.getBooks());
		
		return orderRepresentation;
	}
	
	public List<OrderRepresentation> getOrders(String customerId) {
		List<OrderRepresentation> orderRepresentations = new ArrayList<OrderRepresentation>();
		
		if (customerId != null) {
				
			for (Order order : orderdao.orderforCustomer(customerId)) {
				
				 OrderRepresentation orderRepresentation = new OrderRepresentation();
			        orderRepresentation.setOrderID(order.getOrderID());
			        orderRepresentation.setStatus(order.getStatus());
			        orderRepresentation.setCustomer(order.getCustomer());
			        orderRepresentation.setBooks(order.getBooks());
			        
			        orderRepresentations.add(orderRepresentation);
			        
		    	}
			
		 		}
		return orderRepresentations;
	}
	
	public OrderRepresentation addOrder(String customerId, String bookId )
	{
		Customer customer = customerDao.getCustomer(customerId);
		List<Book> books = new ArrayList<Book>();
		Book book = bookDao.searchId(bookId);
		books.add(book);
        Order order = orderdao.addOrder(customer, "State Street", "Michale", "Visa", "1234-567-8907", books);
		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setBooks(books);
		orderRep.setOrderID(order.getOrderID());
		orderRep.setCustomer(order.getCustomer());
		orderRep.setStatus(order.getStatus());
		System.out.println("after activity");
		
		return orderRep;
		
	}
	
	/*public OrderRepresentation addBookToOrder(String customerId, String bookId) {

		// Get the order
		//Order order = orderdao.getCustomerCurrentOrder(customerId);
		
		// Get the book
		Book book = bookDao.searchId(bookId);
		
		// Update the order
		// We can only do these actions in the Open state
		if (order != null) {
			boolean exists = false;
			for (Line line : order.getLines()) {
				if (line.getBook().getId().equals(book.getId())) {
					line.setQuantity(line.getQuantity() +1);
					exists = true;
				}
			}
			if (!exists) {
				order.addBook(book, 1);
			}
		} else {
			Customer customer = customerDao.getCustomer(customerId);
			order = orderdao.addOrder(customer, customer.getAddresses().get(0), 
					customer.getAddresses().get(0), customer.getCreditCards().get(0),
					shippingCompanyDao.getShippingCompanies().get(0), new ArrayList<Line>(), 
					false, "Open");
			order.addBook(book, 1);
		}

		return createRepresentation(order);
	}*/
	
	
	
	
	public String cancelOrder(String orderID)
	{
	
        String response = orderdao.cancelOrder(orderID);
		
		return response;
	}
	public String deleteOrder(String orderID)
	{
	
        String response = orderdao.deleteOrder(orderID);
		
			
		return response;
	}
	
	

}
