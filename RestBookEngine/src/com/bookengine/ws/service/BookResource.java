package com.bookengine.ws.service;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.workflow.BookActivity;


@Path("/bookservice/")
public class BookResource implements BookService {

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/book")
	public Set<BookRepresentation> searchAllBooks() {
		System.out.println("GET METHOD Request for all books .............");
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchAllBooks();
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/book/{bookId}")
	public BookRepresentation searchId(@PathParam("bookId") String bookId) {
		System.out.println("GET METHOD Request from Client with bookRequest String ............."
						+ bookId);
		BookActivity bookActivity = new BookActivity();
		return bookActivity.searchId(bookId);
	}

}
