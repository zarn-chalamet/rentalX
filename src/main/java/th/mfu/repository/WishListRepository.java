package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import th.mfu.model.WishList;
@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {
    @Query(value = "Select * from wishlist where user_id=?1 and dorm_id=?2",nativeQuery = true)
    WishList findByUserIdAndDormId(Long userId, Long dormId);
}
