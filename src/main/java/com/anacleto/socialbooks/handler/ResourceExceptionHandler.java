package com.anacleto.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anacleto.socialbooks.model.ErrorDetail;
import com.anacleto.socialbooks.service.exception.BookNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDetail> BookNotFoundExceptionHandler(BookNotFoundException e, HttpServletRequest request) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(404l);
		error.setTitle("The book couldn't be found.");
		error.setDeveloperMessage("http://errors.socialbooks.com/404");
		error.setTimestanp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
