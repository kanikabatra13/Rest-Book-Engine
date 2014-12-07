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
		Customer customer = new Customer();
		PaymentInfo paymentinfo = new PaymentInfo();
		
		Order order1 = new Order("546","X1","Shipped",customer,paymentinfo);
		Order order2= new Order("782","X2","Ordered",customer,paymentinfo);
		Order order3= new Order("389","X3","Processed",customer,paymentinfo);
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
	}
	

	public Order buyBooks(String bookId, Customer customer)
	{
		Order order = new Order();
		//Customer customer = new Customer(name, address,ph,custId);
		PaymentInfo paymentinfo = new PaymentInfo();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		
	    String id = "" + randomInt;
	    order.setOrderID(id);
	    order.setBookID(bookId);
	    order.setCustomer(customer);
	    order.setPaymentinfo(paymentinfo);
	    order.setStatus("Ordered");		
		orders.add(order);
		return order;
	}

	public Order getOrder(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
				return order;
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
	
	public Customer getCustomerInfo(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
				return order.getCustomer();
		}
		return null;
	}
	
	public List<Order> getOrdersByCustomerId(String customerId) {
		List<Order> customerOrders = new ArrayList<Order>();
		for (Order order : orders){
			if (order.getCustomer().getCustID().equals(customerId)) {
				customerOrders.add(order);
			}
		}
		return customerOrders;
	    }
	
	
	public Order getCustomerOrder(String id, String customerId) {
		List<Order> orders = getOrdersByCustomerId(customerId);
		for (Order order : orders) {
			if(order.getOrderID().equals(id)) {
				return order;
			}
		}
		return null;
	}
}

