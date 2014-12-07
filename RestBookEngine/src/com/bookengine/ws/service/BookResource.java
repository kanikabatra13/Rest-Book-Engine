package com.bookengine.ws.service;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;



import com.bookengine.ws.Book;
import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;
import com.bookengine.ws.service.workflow.BookActivity;
import com.bookengine.ws.service.workflow.OrderActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)


@Path("/bookservice/")
public class BookResource implements BookService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/book")
	public List<BookRepresentation> searchAllBooks() {
		System.out.println("GET METHOD Request for all books .............");
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchAllBooks();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/book/bookId/{bookId}")
	public BookRepresentation searchId(@PathParam("bookId") String bookId) {
		System.out.println("GET METHOD Request from Client with Book Id ............."
						+ bookId);
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchId(bookId);
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/book/bookauthor/{authorName}")
	public BookRepresentation searchAuthor(@PathParam("authorName") String authorName) {
		System.out.println("GET METHOD Request from Client with Book Author Name ............."
						+ authorName);
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchAuthor(authorName);
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/book/bookname/{bookName}")
	public BookRepresentation searchBookName(@PathParam("bookName") String bookName) {
		System.out.println("GET METHOD Request from Client with Book Name............."
						+ bookName);
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchBookName(bookName);
		
	}
	

	

	
	
		
	}
	
	
	


