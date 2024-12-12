package com.always_upgrade.jobApplication.Reviews;

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
    public ResponseEntity<List<Reviews>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Reviews review) {
        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        }
    else {
        return new ResponseEntity<>("Review Not Saved",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Reviews> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
          return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);

    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Reviews updatedReviews) {
        boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, updatedReviews);
        if (isReviewUpdated) {
            return new ResponseEntity<>("Review Successfully Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Updated", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean isReviewDeleted=reviewService.deleteReview(companyId,reviewId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("Review Successfully Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Updated", HttpStatus.NOT_FOUND);
        }
    }
}
