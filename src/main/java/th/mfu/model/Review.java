package th.mfu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    private Long dormId;
    private Long userId;
    private int rating;
    private String reviewFromUser;
    private LocalDateTime timestamp;

    public Review() {
    }

    public Review(Long dormId, Long userId, int rating, String reviewFromUser, LocalDateTime timestamp) {
        this.dormId = dormId;
        this.userId = userId;
        this.rating = rating;
        this.reviewFromUser = reviewFromUser;
        this.timestamp = timestamp;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getDormId() {
        return dormId;
    }

    public void setDormId(Long productId) {
        this.dormId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewFromUser() {
        return reviewFromUser;
    }

    public void setReviewFromUser(String review) {
        this.reviewFromUser = review;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
