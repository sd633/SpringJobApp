package com.example.springBoot03.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviewsController(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReviewController(@PathVariable Long companyId,
                                            @RequestBody Review review){
        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if (isReviewSaved)
            return new ResponseEntity<>("Review Added Successfully",
                    HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Saved",
                    HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewController(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK) ;
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewController(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review updatedReview) {
        if (reviewService.updateReview(companyId, reviewId, updatedReview))
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewController(@PathVariable Long reviewId, @PathVariable Long companyId){
        if(reviewService.deleteReview(reviewId, companyId))
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);

        return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
    }
}
