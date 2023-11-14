package th.mfu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.dto.ReviewDto;
import th.mfu.model.Review;
import th.mfu.repository.ReviewRepository;
import th.mfu.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(ReviewDto reviewDto) {
        Review review = new Review(reviewDto.getDormId(),reviewDto.getUserId(),reviewDto.getRating(),reviewDto.getReviewFromUser(),reviewDto.getTimestamp());
        return reviewRepository.save(review);
    }
}
