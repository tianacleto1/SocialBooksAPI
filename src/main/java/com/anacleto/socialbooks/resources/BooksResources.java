package com.anacleto.socialbooks.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.anacleto.socialbooks.model.Book;
import com.anacleto.socialbooks.repository.BooksRepository;

@RestController
@RequestMapping("/books")
public class BooksResources {
	
	@Autowired
	private BooksRepository booksRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> list() {
		return booksRepository.findAll();
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void insert(@RequestBody Book book) {
		booksRepository.save(book);
	}
}
