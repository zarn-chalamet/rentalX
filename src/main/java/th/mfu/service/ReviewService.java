package th.mfu.service;

import th.mfu.dto.ReviewDto;
import th.mfu.model.Review;

import java.util.List;

public interface ReviewService {
    Review save(ReviewDto reviewDto);

    List<Review> findByDormId(Long dormId);
}
