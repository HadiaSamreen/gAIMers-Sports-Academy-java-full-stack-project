 package com.example.JavaFullStackProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.JavaFullStackProject.Service.ReviewService;
import com.example.JavaFullStackProject.entity.LogIn;
import com.example.JavaFullStackProject.entity.Reviews;




@Controller
public class ReviewsController {
  private ReviewService revServ;
  public ReviewsController(ReviewService revServ)
  {
	  this.revServ=revServ;
  }
 @GetMapping("/addNewReview")
  public String createReview(Model model)
	  {
		  Reviews revCreateObj=new Reviews();
		  model.addAttribute("revObj",revCreateObj);
		  return "createReview";
	  }
  @GetMapping("/seeAllReviews")
  public String getAllReviewsFromDb(Model model)
  {
	  model.addAttribute("reviewsList",revServ.readAllReviews());
	  return "ReviewsPage";
  }
  @PostMapping("/insertReview")
  public String insertToDb(@ModelAttribute("revObj") Reviews rev)
  {
	  revServ.saveReviews(rev);
	  return "redirect:/seeAllReviews";
  }
  @GetMapping("updateReview/{id}")
  public String updateReview(@PathVariable int id,Reviews fromdb,Model model) {

      model.addAttribute("update" ,revServ.updateReview(id,fromdb));
      return "updateReview";
  }
	@PostMapping("/updateAndSaveReview/{id}")
	public String updateandSave(@PathVariable int id, @ModelAttribute("update")Reviews newfromdb ,Reviews fromdb) {
		Reviews existingdb=revServ.updateReview(id,fromdb);
		existingdb.setId(newfromdb.getId());
		existingdb.setName(newfromdb.getName());
		existingdb.setAchievements(newfromdb.getAchievements());
		existingdb.setFeedback(newfromdb.getFeedback());
		existingdb.setRatings(newfromdb.getRatings());
		return "redirect:/seeAllReviews";
	}
	@GetMapping("/deleteReview/{id}")
	public String deleteFromDb(@PathVariable int id) {
		
		revServ.deleteReviews(id);
		return "redirect:/seeAllReviews";
		
	}
	@GetMapping("/gAIMers")
	public String getAlldataFromHome(Model model){
		model.addAttribute("ReviewsList",revServ.readAllReviews());
		return "Home";

}
	@GetMapping("/HomePage")
	public String getAlldataFromHome1(Model model){
		model.addAttribute("ReviewsList",revServ.readAllReviews());
		return "homePage";

}
	@GetMapping("/About")
	public String insertToDb3(@ModelAttribute("revObj")  Reviews rev) {
		//revServ.saveReviews(rev);  //obj is insert into db by using save 
		return "About";
}
	
	@GetMapping("/CONTACT")
	public String insertToDb2(@ModelAttribute("revObj")  Reviews rev) {
		//revServ.saveReviews(rev);  //obj is insert into db by using save 
		return "ContactUs";
}
	@GetMapping("/login")
	public String loginPage(Model model) {
		LogIn admin=new LogIn();
		model.addAttribute("adminObj",admin);
		return "LgIn";
	}
	@GetMapping("/SignUp")
	public String SignUpPage(Model model) {
		LogIn admin=new LogIn();
		model.addAttribute("adminObj",admin);
		return "LgIn";
	}
	@GetMapping("/logout")
	public String logoutPage(Model model) {
		return "logout";
	}
	@GetMapping("/validatingData")
	public String validateLoginCredentials(@ModelAttribute("adminObj")LogIn adminDetails) {
		if(adminDetails.getUserName().equals("Adminlogin")&& adminDetails.getPassword().equals("1234abcd")) {
			return "redirect:HomePage";
		}
		else {
			return "LgIn";
		}
		
	}
}