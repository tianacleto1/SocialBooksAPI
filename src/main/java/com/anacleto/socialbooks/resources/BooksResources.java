package com.anacleto.socialbooks.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.anacleto.socialbooks.model.Book;

@RestController
public class BooksResources {
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> list() {
		Book book1 = new Book();
		book1.setId(1L);
		book1.setName("Applied Rest");
		
		Book book2 = new Book();
		book2.setId(2L);
		book2.setName("GIT Step By Step");
		
		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		
		return books;
	}
}
