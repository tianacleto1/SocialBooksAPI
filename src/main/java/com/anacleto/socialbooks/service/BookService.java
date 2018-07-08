package com.anacleto.socialbooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.anacleto.socialbooks.model.Book;
import com.anacleto.socialbooks.repository.BookRepository;
import com.anacleto.socialbooks.service.exception.BookNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	
	public Book getById(Long id) {
		Book book = bookRepository.getById(id);
		
		if (book == null) {
			throw new BookNotFoundException("Book not found.");
		}
		
		return book;
	}
	
	public Book save(Book book) {
		book.setId(null);
		
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		try {
		    bookRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BookNotFoundException("The Book can not be deleted because it was not found.");
		}
	}
	
	public void update(Book book) {
		checkBookExistence(book);
		
		bookRepository.save(book);
	}
	
	private void checkBookExistence(Book book) {
		getById(book.getId());
	}
}
