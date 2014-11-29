package com.bookengine.ws.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BookRepresentation extends Representation{

	private String bookId;
	private String isbn;
	private String bookName;
	private String authorName;
	private double price;

	public BookRepresentation() {
		}

//	public BookRepresentation(String id, String bName, String aName, String isbn) {
//		this.bookId = id;
//		this.bookName = bName;
//		this.authorName = aName;
//		this.isbn = isbn;
//	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
