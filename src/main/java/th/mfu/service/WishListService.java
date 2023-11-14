package th.mfu.service;

import th.mfu.dto.WishListDto;
import th.mfu.model.Dorm;
import th.mfu.model.WishList;

import java.util.List;

public interface WishListService {
    WishList save(WishListDto wishListDto);

    WishList findByUserIdAndDormId(Long userId, Long dormId);

    List<WishList> findByUserId(Long userId);

    void deleteFromWishList(Long userId, Long dormId);
}
