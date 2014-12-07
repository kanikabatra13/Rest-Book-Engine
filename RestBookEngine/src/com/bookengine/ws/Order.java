package com.bookengine.ws;

import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "")
public class Order {

	private String orderID;
	private List<Book> books;
	
	private String status;
	private String shipaddress;
	private Customer customer = new Customer();
	private String namecard;
	private String cardtype;
	private String cardnum;
	
	public Order()
	{
		
	}
	 
	public Order(String orderID, List<Book> books, String status, String shipaddress, Customer customer, String namecard, String cardtype, String cardnum)
	{
		this.orderID = orderID;
		//this.bookID = bookID;
		this.status = status;
		this.books = books;
		this.shipaddress = shipaddress;
		this.customer = customer;
		this.namecard = namecard;
		this.cardtype = cardtype;
		this.cardnum = cardnum;
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

	
		public String getShipaddress() {
			return shipaddress;
		}

		public void setShipaddress(String shippaddress) {
			this.shipaddress = shippaddress;
		}

		public String getCardtype() {
			return cardtype;
		}

		public void setCardtype(String cardtype) {
			this.cardtype = cardtype;
		}

		public String getCardnum() {
			return cardnum;
		}

		public void setCardnum(String cardnum) {
			this.cardnum = cardnum;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		public String getNamecard() {
			return namecard;
		}

		public void setNamecard(String namecard) {
			this.namecard = namecard;
		}


}

