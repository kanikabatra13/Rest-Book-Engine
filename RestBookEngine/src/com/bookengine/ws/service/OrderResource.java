package com.bookengine.ws.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;
import com.bookengine.ws.service.workflow.OrderActivity;


@Path("/orderservice/")
public class OrderResource implements OrderService{

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	public OrderRepresentation addOrder(OrderRequest  orderRequest) {
		System.out.println("POST METHOD Request from Client with Book ID............." + orderRequest.getBookId());
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.addOrder(orderRequest.getBookId());
	}

	

	public String getOrderStatus(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
