package com.anacleto.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anacleto.socialbooks.model.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
