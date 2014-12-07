package com.bookengine.ws;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customer")
public class Customer {
	 
	private String name;
	private String custID;
	

	private String address;
	private String phone;
	private String userName;
	
	private String password;
	private List<Book> books;
	
	public Customer(){
		
	}
	
	public Customer(String custID, String name, String userName, String password, String address, String phone){
		
		this.custID = custID;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
			
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
