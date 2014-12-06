package com.bookengine.ws.service;

import javax.jws.WebService;
import javax.xml.ws.Response;

import com.bookengine.ws.Customer;
import com.bookengine.ws.Order;
import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;

@WebService
public interface OrderService {

	public OrderRepresentation addOrder(OrderRequest orderrequest);
	public String getOrderStatus(String orderID);
	public String cancelOrder(String orderID);
	public String deleteOrder(String orderID);
}
