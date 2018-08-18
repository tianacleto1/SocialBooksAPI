package com.anacleto.socialbooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anacleto.socialbooks.model.Author;
import com.anacleto.socialbooks.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> getAll() {
		return authorRepository.findAll();
	}
}
