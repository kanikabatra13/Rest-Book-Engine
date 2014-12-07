package com.bookengine.ws;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;




public class OrderDAO {

	private List<Order> orders = new ArrayList<Order>();


	public OrderDAO() {
//		order.setOrderID("567");
//		order.setBookID("3");
//		Set status = new HashSet();
//		status.add("Ordered");
//		order.setStatus(status);
		Customer customer1 = new Customer("1","Kanika", "kanika13", "abc@123", "N Sheridan Road Chicago", "123-678-8890");
		Customer customer2 = new Customer("2","Chirag","kanika13", "abc@123", "N Sheridan Road Chicago", "123-678-8890");
		Customer customer3 = new Customer("3","Mehar", "kanika13", "abc@123", "N Sheridan Road Chicago", "123-678-8890");
		
		 List<Book> books = new ArrayList<Book>();
		 List<Book> books2 = new ArrayList<Book>();
		 List<Book> books3 = new ArrayList<Book>();
		
		Book book1 = new Book("X1","Web Services","Kanika","567-789", 78.90);
		Book book2= new Book("X2","XML Programming","Julius","7890-567", 80);
		Book book3= new Book("X3","Database Programming","Yang","234-890", 100.67);
		Book book4= new Book("X3","Database Programming","Yang","234-890", 100.67);
		
		books.add(book1);
		books2.add(book2);
		books2.add(book3);
		books3.add(book4);
		
		Order order1 = new Order("546",books,"Shipped", "State Street",customer1,"Kanika","Visa", "0000-1234-0342-1453");
		Order order2= new Order("782", books2,"Ordered", "Lincoln Park", customer2,"Chirag","MasterCard", "0000-2345-7890");
		Order order3= new Order("389", books3,"Processed","Sheridan Road", customer3,"John Smith", "AMEX", "234-8900-78900");
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
	}
	

	public Order addOrder(Customer customer, String shipaddress, String cardname, String cardtype, String cardnum, List<Book> books)
	{
		Order order = new Order();
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		
	    String id = "" + randomInt;
	    order.setOrderID(id);
	    order.setCustomer(customer);
	    order.setStatus("Ordered");	
	    order.setShipaddress(shipaddress);
	    order.setNamecard(cardname);
	    order.setCardtype(cardtype);
	    order.setCardnum(cardnum);
	    order.setBooks(books);
	    
		orders.add(order);
		return order;
	}

	public Order UpdateOrder(String orderID,Customer customer, String shipaddress, String cardname, String cardtype, String cardnum, List<Book> books)
	{
		Order order = getOrder(orderID);
		
		
	    order.setCustomer(customer);
	    order.setStatus("Ordered");	
	    order.setShipaddress(shipaddress);
	    order.setNamecard(cardname);
	    order.setCardtype(cardtype);
	    order.setCardnum(cardnum);
	    order.setBooks(books);
	     return order;
	}

	
	public Order getOrder(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
				return order;
		}
		return null;
	}
	
	
	
	public List<Order> orderforCustomer(String customerId) {
		List<Order> customerOrders = new ArrayList<Order>();
		for (Order order : orders){
			if (order.getCustomer().getCustID().equals(customerId)) {
				customerOrders.add(order);
			}
		}
		return customerOrders;
	    }
	
	
	public Order getCustomerOrder(String id, String customerId) {
		List<Order> orders = orderforCustomer(customerId);
		for (Order order : orders) {
			if(order.getOrderID().equals(id)) {
				return order;
			}
		}
		return null;
	}
	
	
	public Customer getCustomerInfo(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
				return order.getCustomer();
		}
		return null;
	}
	

	public String getOrderStatus(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
				return order.getStatus();
		}
		return null;
	}
	
	public String cancelOrder(String orderID){	
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
			{   
				if(order.getStatus().equals("Shipped"))
				{
					return "Your Order has been Shipped it cannot be cancelled";
				}
				  
				else{
					
			        order.setStatus("Cancelled");
			        return "Your Order has been cancelled";
				}
				
		     }
		}
			return null;
	}
	
	public String deleteOrder(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
			{   
				orders.remove(order);
					return "Order has been Deleted.";
					
				}
			
			}
		return "null";
	}
}

