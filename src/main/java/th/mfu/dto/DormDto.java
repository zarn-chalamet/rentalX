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

    public DormDto() {
    }

    public DormDto(String dormName, String dormDesc, Integer price, Set<Photo> dormPhotos, User landlord) {
        this.dormName = dormName;
        this.dormDesc = dormDesc;
        this.price = price;
        this.dormPhotos = dormPhotos;
        this.landlord = landlord;
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
}
