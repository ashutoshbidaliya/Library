package org.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.library.dao.BookRepository;
import org.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService {	
	@Autowired
	public BookRepository repo;
		
	public BookService(BookRepository repo) {
		this.repo = repo;
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		repo.findAll()
		.forEach(books::add);
//		.forEach(a ->getAllBooks());
		return books;		
	}
	
//	Find book by code
	public Optional<Book> getBook(int code) {
		return repo.findById(code);
	}
	
//	Find book by author
	public Book getBook(String author) {
		return repo.findByAuthor(author);
	}
	
//	Add book to the library
	public Book addBook(Book book) {
		return repo.save(book);
	}
	
//	Update the details of the book
	public void updateBook(int code, Book book) {
		repo.save(book);
	}
	
//	Delete book from library
	public void deleteBook(int code) {
		repo.deleteById(code);
	}
	
}
