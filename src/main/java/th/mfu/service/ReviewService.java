package th.mfu.service;

import th.mfu.dto.ReviewDto;
import th.mfu.model.Review;

public interface ReviewService {
    Review save(ReviewDto reviewDto);
}
