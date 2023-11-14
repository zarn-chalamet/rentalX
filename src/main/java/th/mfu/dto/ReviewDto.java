package th.mfu.dto;

import java.time.LocalDateTime;

public class ReviewDto {
    private Long dormId;
    private Long userId;
    private int rating;
    private String reviewFromUser;
    private LocalDateTime timestamp;

    public ReviewDto() {
    }

    public ReviewDto(Long dormId, Long userId, int rating, String reviewFromUser, LocalDateTime timestamp) {
        this.dormId = dormId;
        this.userId = userId;
        this.rating = rating;
        this.reviewFromUser = reviewFromUser;
        this.timestamp = timestamp;
    }

    public Long getDormId() {
        return dormId;
    }

    public void setDormId(Long dormId) {
        this.dormId = dormId;
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

    public void setReviewFromUser(String reviewFromUser) {
        this.reviewFromUser = reviewFromUser;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
