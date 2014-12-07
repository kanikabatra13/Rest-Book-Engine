package com.bookengine.ws.service;

import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import com.bookengine.ws.Book;
import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;


@WebService
public interface BookService {

	public List<BookRepresentation> searchAllBooks();
	public BookRepresentation searchId(String bookId);
	public BookRepresentation searchAuthor(String authorName);
	public BookRepresentation searchBookName(String bookName);
	
	//public BookRepresentation searchAuthor(String authorName);
	

}
