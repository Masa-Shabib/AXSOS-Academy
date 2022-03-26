package com.waterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.waterBnB.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{
	List <Review> findAll();
}
