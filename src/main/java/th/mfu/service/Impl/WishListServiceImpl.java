package th.mfu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.dto.WishListDto;
import th.mfu.model.Dorm;
import th.mfu.model.WishList;
import th.mfu.repository.WishListRepository;
import th.mfu.service.WishListService;
@Service
public class WishListServiceImpl implements WishListService {
    @Autowired
    private WishListRepository wishListRepository;
    @Override
    public WishList save(WishListDto wishListDto) {
        WishList wishList = new WishList(wishListDto.getUser(),wishListDto.getDorm());
        return wishListRepository.save(wishList);
    }

    @Override
    public WishList findByUserIdAndDormId(Long userId, Long dormId) {
        WishList wishList = wishListRepository.findByUserIdAndDormId(userId,dormId);
        return null;
    }
}
