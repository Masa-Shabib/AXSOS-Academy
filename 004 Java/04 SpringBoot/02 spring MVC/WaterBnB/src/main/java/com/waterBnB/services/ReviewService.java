package com.waterBnB.services;

import org.springframework.stereotype.Service;

import com.waterBnB.repositories.ReviewRepository;

@Service
public class ReviewService {
	public final ReviewRepository reviewRepository;

	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
}
