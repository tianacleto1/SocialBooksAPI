package com.anacleto.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anacleto.socialbooks.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
