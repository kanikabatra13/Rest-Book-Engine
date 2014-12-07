package com.bookengine.ws.service;

import java.util.List;

import javax.jws.WebService;
import com.bookengine.ws.Customer;
import com.bookengine.ws.Order;
import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;
import javax.ws.rs.core.Response;

@WebService
public interface OrderService {

	
	public OrderRepresentation getOrder(String orderID);
	public List<OrderRepresentation> getOrders();
	public OrderRepresentation addOrder(OrderRepresentation orderrep);
	//public OrderRepresentation updateOrder(String id, OrderRepresentation orderRequest);
	public Response deleteOrder(String id);
}
