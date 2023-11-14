package th.mfu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.dto.WishListDto;
import th.mfu.model.Dorm;
import th.mfu.model.WishList;
import th.mfu.repository.WishListRepository;
import th.mfu.service.WishListService;

import java.util.List;

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
        return wishListRepository.findByUserIdAndDormId(userId,dormId);
    }

    @Override
    public List<WishList> findByUserId(Long userId) {
        return wishListRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteFromWishList(Long userId, Long dormId) {
        int rowsAffected = wishListRepository.deleteWishListByUserIdAndDormId(userId, dormId);
        if (rowsAffected > 0) {
            System.out.println("delete successfully!");
        } else {
            // Handle the case where the row was not found or deleted
            // You can throw an exception or handle it according to your application logic
            System.out.println("error");
        }
    }

}
