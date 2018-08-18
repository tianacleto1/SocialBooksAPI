package com.anacleto.socialbooks.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anacleto.socialbooks.model.Author;
import com.anacleto.socialbooks.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorResource {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> getAuthors() {
		return ResponseEntity.status(HttpStatus.OK).body(authorService.getAll());
	}
}
