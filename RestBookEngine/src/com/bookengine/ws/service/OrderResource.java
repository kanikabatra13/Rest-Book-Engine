package com.bookengine.ws.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;
import com.bookengine.ws.service.workflow.BookActivity;
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

	

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/order/{orderId}")
	public String getOrderStatus(@PathParam("orderId") String orderID) {
		System.out.println("GET METHOD Request from Client with bookRequest String ............."
						+ orderID);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrderStatus(orderID);
		
	}
	
	
}
