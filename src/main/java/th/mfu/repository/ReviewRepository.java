package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import th.mfu.model.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query(value = "Select * from review where dorm_id=?1",nativeQuery = true)
    List<Review> findByDormId(Long dormId);
}
