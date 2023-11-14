package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import th.mfu.model.WishList;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {
    @Query(value = "Select * from wish_list where user_id=?1 and dorm_dorm_id=?2",nativeQuery = true)
    WishList findByUserIdAndDormId(Long userId, Long dormId);
    @Query(value = "Select * from wish_list where user_id=?1",nativeQuery = true)
    List<WishList> findAllByUserId(Long userId);
    @Modifying
    @Query(value = "DELETE from wish_list where user_id=?1 and dorm_dorm_id=?2",nativeQuery = true)
    int deleteWishListByUserIdAndDormId(Long userId, Long dormId);
}
