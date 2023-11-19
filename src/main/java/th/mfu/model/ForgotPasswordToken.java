package th.mfu.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ForgotPasswordToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String token;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    @Column(nullable = false)
    private LocalDateTime expiredTime;
    @Column(nullable = false)
    private boolean isUsed;

    public ForgotPasswordToken() {
    }

    public ForgotPasswordToken(String token, User user, LocalDateTime expiredTime, boolean isUsed) {
        this.token = token;
        this.user = user;
        this.expiredTime = expiredTime;
        this.isUsed = isUsed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
