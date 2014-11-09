package com.bookengine.ws.service.representation;

import com.bookengine.ws.Customer;
import com.bookengine.ws.PaymentInfo;

public class OrderRepresentation {
	
	private String orderID;
	private String bookID;
	private String status;
	private Customer customer = new Customer();
	private PaymentInfo paymentinfo = new PaymentInfo();
	
	public OrderRepresentation()
	{
		
	}
	 
	public OrderRepresentation(String orderID, String bookID, String status, Customer customer, PaymentInfo paymentinfo)
	{
		this.orderID = orderID;
		this.bookID = bookID;
		this.status = status;
		this.customer = customer;
		this.paymentinfo = paymentinfo;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PaymentInfo getPaymentinfo() {
		return paymentinfo;
	}

	public void setPaymentinfo(PaymentInfo paymentinfo) {
		this.paymentinfo = paymentinfo;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

}
