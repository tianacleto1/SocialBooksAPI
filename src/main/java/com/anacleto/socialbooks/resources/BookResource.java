package com.anacleto.socialbooks.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.anacleto.socialbooks.model.Book;
import com.anacleto.socialbooks.service.BookService;
import com.anacleto.socialbooks.service.exception.BookNotFoundException;

@RestController
@RequestMapping("/books")
public class BookResource {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Book>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Book book) {
		book = bookService.save(book);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(book.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
		Book book = bookService.getById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
		bookService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<Void> updateBook(@RequestBody Book book, @PathVariable("id") Long id) {
		book.setId(id);
		bookService.update(book);
		
		return ResponseEntity.noContent().build();
	}
}
