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
    private Integer bedroom;
    private Integer bathroom;
    private String city;
    private String amenities;
    private Double latitude;
    private Double longitude;
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

    public Dorm(String dormName, String dormDesc, Integer price, Integer bedroom, Integer bathroom, String city, String amenities, Double latitude, Double longitude, Set<Photo> dormPhotos, User landlord) {
        this.dormName = dormName;
        this.dormDesc = dormDesc;
        this.price = price;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.city = city;
        this.amenities = amenities;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public void setDormPhotos(Set<Photo> dormPhotos) {
        this.dormPhotos = dormPhotos;
    }

    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
