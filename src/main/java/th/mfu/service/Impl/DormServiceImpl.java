package th.mfu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.dto.DormDto;
import th.mfu.model.Dorm;
import th.mfu.repository.DormRepository;
import th.mfu.service.DormService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DormServiceImpl implements DormService {
    @Autowired
    private DormRepository dormRepository;
    @Override
    public Dorm save(DormDto dormDto) {
        Dorm dorm = new Dorm(dormDto.getDormName(),dormDto.getDormDesc(), dormDto.getPrice(),
                dormDto.getBedroom(),dormDto.getBathroom(),dormDto.getCity(),
                dormDto.getAmenities(),dormDto.getLatitude(),dormDto.getLongitude(),
                dormDto.getDormPhotos(),dormDto.getLandlord());
        return dormRepository.save(dorm);
    }

    @Override
    public void updateDormInfo(Dorm originalDorm, DormDto updateDorm) {
        Long originalDormId = originalDorm.getDormId();
        updateDorm.setLandlord(originalDorm.getLandlord());
        if(updateDorm.getDormName().equals("")){
            updateDorm.setDormName(originalDorm.getDormName());
        }
        if(updateDorm.getDormDesc().equals("")){
            updateDorm.setDormDesc(originalDorm.getDormDesc());
        }
        if(updateDorm.getPrice() == null){
            updateDorm.setPrice(originalDorm.getPrice());
        }
        if(updateDorm.getBedroom() == null){
            updateDorm.setBedroom(originalDorm.getBedroom());
        }
        if(updateDorm.getBathroom() == null){
            updateDorm.setBathroom(originalDorm.getBathroom());
        }
        if(updateDorm.getCity().equals("")){
            updateDorm.setCity(originalDorm.getCity());
        }
        if(updateDorm.getPrice() == 0){
            updateDorm.setPrice(originalDorm.getPrice());
        }
        if(updateDorm.getAmenities().equals("")){
            updateDorm.setAmenities(originalDorm.getAmenities());
        }
        if(updateDorm.getLatitude() == null){
            updateDorm.setLatitude(originalDorm.getLatitude());
        }
        if(updateDorm.getLongitude() == null){
            updateDorm.setLongitude(originalDorm.getLongitude());
        }
        dormRepository.updateDorm(originalDormId, updateDorm.getDormName(), updateDorm.getDormDesc(),
                updateDorm.getPrice(), updateDorm.getBedroom(), updateDorm.getBathroom(),
                updateDorm.getCity(), updateDorm.getAmenities(), updateDorm.getLatitude(),
                updateDorm.getLongitude());
    }


    @Override
    public List<Dorm> getAllDorms() {
        return dormRepository.findAll();
    }

    @Override
    public List<Dorm> findByKeyword(String keyword) {
        List<Dorm> searchResults = new ArrayList<>();
        for (Dorm dorm : dormRepository.findAll()) {
            //you can add dorm description here
            if (dorm.getDormName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(dorm);
            }
        }
        return searchResults;
    }

    @Override
    public List<Dorm> getDormsSortedByPriceLowToHigh() {
        List<Dorm> sortedDorms = new ArrayList<>(dormRepository.findAll());
        sortedDorms.sort(Comparator.comparing(Dorm::getPrice));
        return sortedDorms;
    }

    @Override
    public List<Dorm> getDormsSortedByPriceHighToLow() {
        List<Dorm> sortedDorms = new ArrayList<>(dormRepository.findAll());
        sortedDorms.sort(Comparator.comparing(Dorm::getPrice).reversed());
        return sortedDorms;
    }

    @Override
    public List<Dorm> getDormsSortedByNameAlphabetically() {
        List<Dorm> sortedDorms = new ArrayList<>(dormRepository.findAll());
        sortedDorms.sort(Comparator.comparing(Dorm::getDormName));
        return sortedDorms;
    }

    @Override
    public Dorm findById(Long dormId) {
        Dorm dorm = dormRepository.findById(dormId).get();
        return dorm;
    }

    @Override
    public List<Dorm> findDormByLandlordId(Long landlordId) {
        return dormRepository.findDormsByLandlordId(landlordId);
    }
}
