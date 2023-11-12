package th.mfu.service;

import th.mfu.dto.DormDto;
import th.mfu.model.Dorm;

import java.util.List;

public interface DormService {
    Dorm save(DormDto dormDto);

    List<Dorm> getAllDorms();

    List<Dorm> findByKeyword(String keyword);

    List<Dorm> getDormsSortedByPriceLowToHigh();

    List<Dorm> getDormsSortedByPriceHighToLow();

    List<Dorm> getDormsSortedByNameAlphabetically();

    Dorm findById(Long dormId);
}
