package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.mfu.model.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
