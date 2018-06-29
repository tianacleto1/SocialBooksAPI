package com.anacleto.socialbooks.resources;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Book> getBookById(@PathVariable("id") Long id) {
		return booksRepository.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") Long id) {
		booksRepository.deleteById(id);
	}
}
