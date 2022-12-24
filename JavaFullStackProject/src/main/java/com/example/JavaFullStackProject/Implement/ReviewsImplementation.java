package com.example.JavaFullStackProject.Implement;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import com.example.JavaFullStackProject.Interface.ReviewInterface;
import com.example.JavaFullStackProject.Service.ReviewService;
import com.example.JavaFullStackProject.entity.Reviews;




@Service
public class ReviewsImplementation implements ReviewService{
     private ReviewInterface revInt;
     public ReviewsImplementation (ReviewInterface revInt)
     {
    	 this.revInt=revInt;
     }
     public Reviews saveReviews(Reviews revObj)
     {
    	 return revInt.save(revObj);
     }
     public List<Reviews>readAllReviews()
     {
    	 return revInt.findAll();
     }
     public Reviews fetchById(int id) throws Exception{
    	 java.util.Optional<Reviews> revObj = revInt.findById(id);
    	 if(revObj.isPresent())
    	 {
    		 return revObj.get();
    	 }
    	 else
    	 {
    		 throw new Exception("not found");
    	 }
     
     }
     public Reviews updateReview(int id, Reviews value){
 		java.util.Optional<Reviews> revObj = revInt.findById(id);	
 		if(revObj.isPresent()) {
 			
			Reviews objFromDB = revObj.get();
 			objFromDB. setId(value. getId());
 			objFromDB.setName(value.getName());
 			objFromDB.setFeedback(value.getFeedback());
 			objFromDB.setAchievements(value.getAchievements());
 			objFromDB.setRatings(value.getRatings());

 	        revInt.save(objFromDB);
 			return objFromDB;
 		}
 		return new Reviews();
 	}
 	public void deleteReviews(int id) {
 		java.util.Optional<Reviews> stdobj = revInt.findById(id);	
 		if(stdobj.isPresent()) {
            revInt.deleteById(id);
 		}

 	}
 	@Override
 	public Reviews getReviewsById(int id) {
 		// TODO Auto-generated method stub
 		return null;
 	}
 	@Override
 	public List<Reviews> viewReviewsFromDB() {
 		// TODO Auto-generated method stub
 		return null;
 	}
	

	
	
 	
}
