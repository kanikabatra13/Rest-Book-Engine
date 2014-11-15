package com.bookengine.ws.service.workflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.bookengine.ws.Book;
import com.bookengine.ws.BookDAO;
import com.bookengine.ws.service.representation.BookRepresentation;

public class BookActivity {

	private static BookDAO dao = new BookDAO();

	public List<BookRepresentation> searchAllBooks() {

		List<Book> books = new ArrayList<Book>();
		List<BookRepresentation> bookRepresentations = new ArrayList<BookRepresentation>();
		books = dao.searchAllBooks();

		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			BookRepresentation bookRepresentation = new BookRepresentation();
			bookRepresentation.setBookId(book.getBookId());
			bookRepresentation.setIsbn(book.getIsbn());
			bookRepresentation.setBookName(book.getBookName());
			bookRepresentation.setAuthorName(book.getAuthorName());

			// now add this representation in the list
			bookRepresentations.add(bookRepresentation);
		}
		return bookRepresentations;
	}

	public BookRepresentation searchId(String id) {

		Book book = dao.searchId(id);

		BookRepresentation bookRep = new BookRepresentation();
		bookRep.setBookId(book.getBookId());
		bookRep.setBookName(book.getBookName());
		bookRep.setIsbn(book.getIsbn());
		bookRep.setAuthorName(book.getAuthorName());

		return bookRep;
	}
	
	
	public BookRepresentation searchAuthor(String authorName) {

		Book book = dao.searchAuthor(authorName);

		BookRepresentation bookRep = new BookRepresentation();
		bookRep.setBookId(book.getBookId());
		bookRep.setBookName(book.getBookName());
		bookRep.setIsbn(book.getIsbn());
		bookRep.setAuthorName(book.getAuthorName());

		return bookRep;
	}
	
	public BookRepresentation searchBookName(String bookName) {

		Book book = dao.searchBookname(bookName);

		BookRepresentation bookRep = new BookRepresentation();
		bookRep.setBookId(book.getBookId());
		bookRep.setBookName(book.getBookName());
		bookRep.setIsbn(book.getIsbn());
		bookRep.setAuthorName(book.getAuthorName());

		return bookRep;
	}
}
