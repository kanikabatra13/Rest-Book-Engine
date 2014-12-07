package com.bookengine.ws.service.workflow;

import com.bookengine.ws.Customer;
import com.bookengine.ws.Order;
import com.bookengine.ws.OrderDAO;
import com.bookengine.ws.service.representation.OrderRepresentation;


public class OrderActivity {
	
	private static final String String = null;
	private static OrderDAO orderdao = new OrderDAO();
	
	public OrderRepresentation addOrder(String bookId, Customer customer )
	{
	    System.out.println("in activity");
        Order order = orderdao.buyBooks(bookId,customer);
       

		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setBookID(order.getBookID());
		orderRep.setOrderID(order.getOrderID());
		orderRep.setCustomer(order.getCustomer());
		orderRep.setPaymentinfo(order.getPaymentinfo());
		orderRep.setStatus(order.getStatus());
		System.out.println("after activity");
		
		return orderRep;
		
	}
	
	public String getOrder(String orderID, String customerId)
	{
	
       // String status = orderdao.getOrderStatus(orderID);
        Order order = orderdao.getCustomerOrder(orderID, customerId);
		
        OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRep.setId(order.getId());
		orderRep.setCustomer(order.getCustomer());
		orderRep.setBillingAddress(order.getBillingAddress());
		orderRep.setShippingAddress(order.getShippingAddress());
		orderRep.setCreditCard(order.getCreditCard());
		orderRep.setShippingCompany(order.getShippingCompany());
		orderRep.setLines(order.getLines());
		orderRep.setPaymentReceived(order.isPaymentReceived());
		orderRep.setOrderState(order.getOrderState());
		setLinks(orderRep);
		return orderRep;
	}
	
	
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
