package com.anacleto.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anacleto.socialbooks.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book getById(Long id);
}