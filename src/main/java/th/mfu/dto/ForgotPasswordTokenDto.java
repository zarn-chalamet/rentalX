package th.mfu.dto;

import th.mfu.model.User;
import java.time.LocalDateTime;

public class ForgotPasswordTokenDto {
    private String token;
    private User user;
    private LocalDateTime expiredTime;
    private boolean isUsed;

    public ForgotPasswordTokenDto() {
    }

    public ForgotPasswordTokenDto(String token, User user, LocalDateTime expiredTime, boolean isUsed) {
        this.token = token;
        this.user = user;
        this.expiredTime = expiredTime;
        this.isUsed = isUsed;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
