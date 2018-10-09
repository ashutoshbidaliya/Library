package org.library.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import java.util.Date;

import org.junit.Before;
import org.library.dao.BookRepository;
import org.library.entity.Book;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BookServiceTest {

	@Mock
	private BookRepository mockBookRepo;
	private Book book;
	private BookService bookServiceTest;
	
	@Before
	public void setUP() {
		MockitoAnnotations.initMocks(this);
		bookServiceTest = new BookService(mockBookRepo);
		book.setCode(1);
		book.setAuthor("Leena Hayden");
		book.setName("Final War");
		book.setVersion(1.0);
		book.setCreateDate(new Date(21-06-2018));
		
		Mockito.when(mockBookRepo.save(any()))
					.thenReturn(book);
		Mockito.when(mockBookRepo.findByAuthor(anyString()))
		.thenReturn(book);


	}
	
	public void testFindByAuthor() {
		//Set up
		final String author = "Leena Hayden";
		
		//now run the test
		final Book result = bookServiceTest.getBook(author);
		
		//Verify the results.
		assertThat(author.equals(result.getAuthor()));
	}
}
