package th.mfu.model;

import javax.persistence.*;

@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OneToOne
    private User user;
    @OneToOne
    private Dorm dorm;

    public WishList() {
    }

    public WishList(User user, Dorm dorm) {
        this.user = user;
        this.dorm = dorm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
