package th.mfu.dto;

import th.mfu.model.Dorm;
import th.mfu.model.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class ReviewDto {
    private User user;
    private Dorm dorm;
    private int rating;
    private String reviewFromUser;
    private LocalDateTime timestamp;

    public ReviewDto() {
    }

    public ReviewDto(User user, Dorm dorm, int rating, String reviewFromUser, LocalDateTime timestamp) {
        this.user = user;
        this.dorm = dorm;
        this.rating = rating;
        this.reviewFromUser = reviewFromUser;
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
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
