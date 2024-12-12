package com.always_upgrade.jobApplication.Reviews;


import java.util.ArrayList;
import java.util.List;

public interface ReviewService {
    List<Reviews> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Reviews reviews);
    Reviews getReview(Long comapnyId,Long reviewId);
    boolean updateReview(Long comapanyId,Long reviewId,Reviews updatedreviews);
    boolean deleteReview(Long companyId, Long reviewId);
}
