package com.bookengine.ws;

public class Customer {
	 
	private String name;
	private String address;
	private String phone;
	private String custId;
	
	public Customer(){
		
	}
	
	public Customer(String name, String address, String phone, String custId){
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.custId = custId;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
}
