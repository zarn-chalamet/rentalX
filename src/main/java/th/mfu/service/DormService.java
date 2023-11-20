package th.mfu.service;

import th.mfu.dto.DormDto;
import th.mfu.model.Dorm;
import th.mfu.model.User;

import java.util.List;

public interface DormService {
    List<Dorm> getAllDorms();

    List<Dorm> findByKeyword(String keyword);

    List<Dorm> getDormsSortedByPriceLowToHigh();

    List<Dorm> getDormsSortedByPriceHighToLow();

    List<Dorm> getDormsSortedByNameAlphabetically();

    Dorm findById(Long dormId);

    List<Dorm> findDormByLandlordId(Long landlordId);

    Dorm save(DormDto dormDto);

    void updateDormInfo(Dorm originalDorm, DormDto updateDorm);

}
