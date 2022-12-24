package com.example.JavaFullStackProject.Service;

import java.util.List;

import com.example.JavaFullStackProject.entity.Reviews;



public interface ReviewService {
	Reviews saveReviews(Reviews revObj);
	List<Reviews>readAllReviews();
	Reviews fetchById(int ReviewsId)throws Exception;
	Reviews updateReview(int id,Reviews value);
	void deleteReviews(int id);
	Reviews getReviewsById(int id);
	List<Reviews> viewReviewsFromDB();
}
