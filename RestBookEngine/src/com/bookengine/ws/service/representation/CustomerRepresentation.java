package com.bookengine.ws.service.representation;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bookengine.ws.Book;
import com.bookengine.ws.Customer;
import com.bookengine.ws.PaymentInfo;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CustomerRepresentation {
	
	
	private String name;
	private String custID;
	

	private String address;
	private String phone;
	private String userName;
	
	private String password;
	private List<Book> books;
	
public CustomerRepresentation(){
		
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
