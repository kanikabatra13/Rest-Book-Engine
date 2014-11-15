package com.bookengine.ws.service;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bookengine.ws.Book;
import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.workflow.BookActivity;


@Path("/bookservice/")
public class BookResource implements BookService {

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/book")
	public List<BookRepresentation> searchAllBooks() {
		System.out.println("GET METHOD Request for all books .............");
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchAllBooks();
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/book/bookId/{bookId}")
	public BookRepresentation searchId(@PathParam("bookId") String bookId) {
		System.out.println("GET METHOD Request from Client with Book Id ............."
						+ bookId);
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchId(bookId);
		
	}
	
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/book/bookauthor/{authorName}")
	public BookRepresentation searchAuthor(@PathParam("authorName") String authorName) {
		System.out.println("GET METHOD Request from Client with Book Author Name ............."
						+ authorName);
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchAuthor(authorName);
		
	}
	
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/book/bookname/{bookName}")
	public BookRepresentation searchBookName(@PathParam("bookName") String bookName) {
		System.out.println("GET METHOD Request from Client with Book Name............."
						+ bookName);
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchBookName(bookName);
		
	}

	
	
		
	}
	
	
	


