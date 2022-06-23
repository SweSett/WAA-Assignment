package edu.miu.springdata1.controller;

import edu.miu.springdata1.entity.Review;
import edu.miu.springdata1.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id){
        var review = reviewService.getById(id);
        return ResponseEntity.ok(review);
    }

    @PostMapping
    public  void saveReview(Review review){
        reviewService.save(review);
    }

    @PutMapping
    public void update(Review review){
        reviewService.save(review);
    }
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id){
        reviewService.delete(id);
    }
}
