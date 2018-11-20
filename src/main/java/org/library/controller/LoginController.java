package org.library.controller;

import java.util.List;
import java.util.Optional;

import org.library.entity.Book;
import org.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private BookService service;
	/*@Autowired
	private BookRepository repository;
	*/
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "home";
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getAllBooks(){
		return (List<Book>) service.getAllBooks();
	}
	
	@RequestMapping( value = "/books/{code}", method =RequestMethod.GET )
	public Optional<Book> getBook(@PathVariable("code") int code) {
		return service.getBook(code);
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public void addBook(@RequestBody Book newbook) {
		service.addBook(newbook);
	}
	
	@RequestMapping(value = "/books/{code}", method = RequestMethod.PUT)
	public void updateBook(@RequestBody Book newbook, @PathVariable("code") int code) {
		if(service.getBook(code) == null)
			service.addBook(newbook);
		else
		service.updateBook(code,newbook);
	}
	
	@RequestMapping( value = "/books/{code}", method =RequestMethod.DELETE )
	public void deleteBook(@PathVariable("code") int code) {
		service.deleteBook(code);
	}
}



