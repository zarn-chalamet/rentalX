package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.mfu.model.Dorm;
@Repository
public interface DormRepository extends JpaRepository<Dorm,Long> {
}
