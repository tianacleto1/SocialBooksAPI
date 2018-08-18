package com.anacleto.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anacleto.socialbooks.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	
}
