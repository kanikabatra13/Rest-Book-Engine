package com.bookengine.ws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.bookengine.ws.Customer;
import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;
import com.bookengine.ws.service.workflow.BookActivity;
import com.bookengine.ws.service.workflow.CustomerActivity;
import com.bookengine.ws.service.workflow.OrderActivity;


@CrossOriginResourceSharing(allowAllOrigins = true)

@Path("/order")
public class OrderResource implements OrderService{
	
	

	@GET
	@Produces({MediaType.APPLICATION_JSON })
	@Path("/{orderId}")
	public  Response getOrder(@PathParam("orderId") String orderID, @QueryParam("username") String username, 
			@QueryParam("password") String password) {
		System.out.println("\nGET METHOD Request from Client to get Order of Order ID............."
						+ orderID);
		OrderActivity orderActivity = new OrderActivity();
		CustomerActivity customerActivity = new CustomerActivity();
		
		// authorize the customer
		String customerId = customerActivity.authenticate(username, password);
		if (customerId != null) {
			return Response.ok(orderActivity.getOrder(orderID, customerId)).build();
		}
		return Response.status(Status.UNAUTHORIZED).build();
		
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/")
	public List<OrderRepresentation> getOrders(
			@QueryParam("username") String username, 
			@QueryParam("password") String password) {
		OrderActivity orderActivity = new OrderActivity();
		CustomerActivity customerActivity = new CustomerActivity();
		String customerId = customerActivity.authenticate(username, password);	
		return orderActivity.getOrders(customerId);
	}

	

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/order")
	public Response addOrder(@QueryParam("book_id") String bookId, @QueryParam("username") String username, 
			@QueryParam("password") String password) {
		System.out.println("POST METHOD Request from Client with Book ID............." );		
		OrderActivity orderActivity = new OrderActivity();
		CustomerActivity customerActivity = new CustomerActivity();
		String customerId = customerActivity.authenticate(username, password);
		if (customerId != null) {
			return Response.ok(orderActivity.addOrder(customerId, bookId)).build();
		}
		return Response.status(Status.UNAUTHORIZED).build();
		
		//System.out.println("after activity");
	}
	

	
	@PUT
	@Produces({ MediaType.APPLICATION_JSON})
	@Path("/cancel/{orderId}")
	public String cancelOrder(@PathParam("orderId") String orderID) {
		System.out.println("\nPUT METHOD Request from Client to cancel the order ............."
						+ orderID);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.cancelOrder(orderID);
		
	}

	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/delete/{orderId}")
	public Response deleteOrder(@PathParam("orderId")String orderID) {
		
		System.out.println("\nDelete METHOD Request from Client to delete Order orderId............." + orderID);
		OrderActivity ordActivity = new OrderActivity();
		String res = ordActivity.deleteOrder(orderID);
				if (res.equals("OK")) {
				return Response.status(Status.OK).build();
		         }
		
	          
		          return null;
     }


	


	public List<OrderRepresentation> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}


	public OrderRepresentation addOrder(OrderRepresentation orderrep) {
		// TODO Auto-generated method stub
		return null;
	}


	public OrderRepresentation getOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}
}
