package th.mfu.dto;

import th.mfu.model.Photo;
import th.mfu.model.User;

import javax.persistence.*;
import java.util.Set;

public class DormDto {
    private String dormName;
    private String dormDesc;
    private Integer price;
    private Set<Photo> dormPhotos;
    private User landlord;
    private Integer bedroom;
    private Integer bathroom;
    private String city;
    private String amenities;
    private Double latitude;
    private Double longitude;

    public DormDto() {
    }

    public DormDto(String dormName, String dormDesc, Integer price, Set<Photo> dormPhotos, User landlord, Integer bedroom, Integer bathroom, String city, String amenities, Double latitude, Double longitude) {
        this.dormName = dormName;
        this.dormDesc = dormDesc;
        this.price = price;
        this.dormPhotos = dormPhotos;
        this.landlord = landlord;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.city = city;
        this.amenities = amenities;
        this.latitude = latitude;
        this.longitude = longitude;
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
