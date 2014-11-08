package com.bookengine.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

	private String bookId;
	private String isbn;
	private String bookName;
	private String authorName;

	public Book() {
		}

	public Book(String id, String bName, String aName, String isbn) {
		this.bookId = id;
		this.bookName = bName;
		this.authorName = aName;
		this.isbn = isbn;
	}

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

}
