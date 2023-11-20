package th.mfu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.dto.ReviewDto;
import th.mfu.model.Review;
import th.mfu.repository.ReviewRepository;
import th.mfu.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(ReviewDto reviewDto) {
        Review review = new Review(reviewDto.getDorm(),reviewDto.getUser(),reviewDto.getRating(),reviewDto.getReviewFromUser(),reviewDto.getTimestamp());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findByDormId(Long dormId) {
        return reviewRepository.findByDormId(dormId);
    }
}
