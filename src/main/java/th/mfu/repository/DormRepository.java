package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import th.mfu.model.Dorm;

import java.util.List;

@Repository
public interface DormRepository extends JpaRepository<Dorm,Long> {
    @Query(value = "Select * from dorm where landlord_id=?1",nativeQuery = true)
    List<Dorm> findDormsByLandlordId(Long landlordId);
}
