package th.mfu.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dormId;
    private String dormName;
    private String dormDesc;
    private Integer price;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "dorm_photos",
            joinColumns = {
                    @JoinColumn(name = "dorm_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "photo_id")
    }
    )
    private Set<Photo> dormPhotos;
    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private User landlord;

    public Dorm() {
    }

    public Dorm(String dormName, String dormDesc, Integer price, Set<Photo> dormPhotos, User landlord) {
        this.dormName = dormName;
        this.dormDesc = dormDesc;
        this.price = price;
        this.dormPhotos = dormPhotos;
        this.landlord = landlord;
    }

    public Long getDormId() {
        return dormId;
    }

    public void setDormId(Long dormId) {
        this.dormId = dormId;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getDormDesc() {
        return dormDesc;
    }

    public void setDormDesc(String dormDesc) {
        this.dormDesc = dormDesc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<Photo> getDormPhotos() {
        return dormPhotos;
    }

    public void setDorms(Set<Photo> dormPhotos) {
        this.dormPhotos = dormPhotos;
    }

    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }
}
