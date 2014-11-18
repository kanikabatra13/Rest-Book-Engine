package com.bookengine.ws.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	@Path("/orderstatus/{orderId}")
	public String getOrderStatus(@PathParam("orderId") String orderID) {
		System.out.println("\nGET METHOD Request from Client to get Order Status of Order ID............."
						+ orderID);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrderStatus(orderID);
		
	}
	
	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/ordercancel/{orderId}")
	public String cancelOrder(@PathParam("orderId") String orderID) {
		System.out.println("\nPUT METHOD Request from Client to cancel the order ............."
						+ orderID);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.cancelOrder(orderID);
		
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/orderdelete/{orderId}")
	public String deleteOrder(@PathParam("orderId")String orderID) {
		
		System.out.println("\nDelete METHOD Request from Client to delete Order orderId............." + orderID);
		OrderActivity ordActivity = new OrderActivity();
		String res = ordActivity.deleteOrder(orderID);
		if (res.equals("OK")) {
			return "order Deleted";
		}
		return null;
	}
	
	
}
