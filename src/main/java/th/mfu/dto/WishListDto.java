package th.mfu.dto;

import th.mfu.model.Dorm;
import th.mfu.model.User;

public class WishListDto {
    private User user;
    private Dorm dorm;

    public WishListDto() {
    }

    public WishListDto(User user, Dorm dorm) {
        this.user = user;
        this.dorm = dorm;
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
}
