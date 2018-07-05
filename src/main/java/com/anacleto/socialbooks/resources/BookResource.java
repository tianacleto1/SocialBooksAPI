package com.anacleto.socialbooks.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anacleto.socialbooks.model.Book;
import com.anacleto.socialbooks.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookResource {
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> list() {
		return bookRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Book book) {
		book = bookRepository.save(book);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(book.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
		Book book = bookRepository.getById(id);
		
		if (book == null) 
			return ResponseEntity.notFound().build();

		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT) 
	public void updateBook(@RequestBody Book book, @PathVariable("id") Long id) {
		book.setId(id);
		bookRepository.save(book);
	}
}
