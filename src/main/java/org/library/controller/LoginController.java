package org.library.controller;

import java.util.List;

import org.library.dao.BookRepository;
import org.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
//	BookService service;
	BookRepository repository;
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "home";
	}
	
	@RequestMapping(value ="/books", method = RequestMethod.GET)
	public List<Book> getAllBooks(){
		return (List<Book>) repository.findAll();
	}
}
