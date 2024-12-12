package com.always_upgrade.jobApplication.Reviews.impl;

import com.always_upgrade.jobApplication.Company.Company;
import com.always_upgrade.jobApplication.Company.CompanyService;
import com.always_upgrade.jobApplication.Reviews.ReviewRepository;
import com.always_upgrade.jobApplication.Reviews.ReviewService;
import com.always_upgrade.jobApplication.Reviews.Reviews;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final CompanyService companyService;
   // private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService=companyService;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> reviews=reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Reviews reviews) {
        Company company=companyService.getCompanyById(companyId);
        if(company!=null)
        {
            reviews.setCompany(company);
            reviewRepository.save(reviews);
        return true;
        }
        return false;
    }

    @Override
    public Reviews getReview(Long companyId, Long reviewId) {
      List<Reviews> reviews=  reviewRepository.findByCompanyId(companyId);
      return reviews.stream().filter(review -> review.getId().equals(reviewId))
              .findFirst()
              .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews updatedreviews) {
        if(companyService.getCompanyById(companyId)!=null){
            updatedreviews.setCompany(companyService.getCompanyById(companyId));
            updatedreviews.setId(reviewId);
            reviewRepository.save(updatedreviews);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)){
        Reviews review=reviewRepository.findById(reviewId).orElse(null);
        Company company=review.getCompany();
        company.getReviews().remove(review);
        review.setCompany(null);
        companyService.updateCompany(companyId,company);
        reviewRepository.deleteById(reviewId);
        return true;
        }
        else {
            return false;
        }
    }


}
