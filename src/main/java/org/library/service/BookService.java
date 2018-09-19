package org.library.service;

import org.library.dao.BookRepository;
import org.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService {	
	private BookRepository repo;
		
	@Autowired
	public BookService(BookRepository repo) {
		this.repo = repo;
	}
	
	public Book findByAuthor(String author)	{
		return repo.findByAuthor(author);
		
	}
	
}
