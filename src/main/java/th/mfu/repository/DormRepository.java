package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import th.mfu.model.Dorm;
import th.mfu.model.Photo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface DormRepository extends JpaRepository<Dorm,Long> {
    @Query(value = "Select * from dorm where landlord_id=?1",nativeQuery = true)
    List<Dorm> findDormsByLandlordId(Long landlordId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE dorm SET " +
            "dorm_name = COALESCE(?2, dorm_name), " +
            "dorm_desc = COALESCE(?3, dorm_desc), " +
            "price = COALESCE(?4, price), " +
            "bedroom = COALESCE(?5, bedroom), " +
            "bathroom = COALESCE(?6, bathroom), " +
            "city = COALESCE(?7, city), " +
            "amenities = COALESCE(?8, amenities), " +
            "latitude = COALESCE(?9, latitude), " +
            "longitude = COALESCE(?10, longitude) " +
            "WHERE dorm_id = ?1", nativeQuery = true)
    void updateDorm(Long originalDormId, String dormName, String dormDesc, Integer price, Integer bedroom,
                   Integer bathroom, String city, String amenities, Double latitude, Double longitude);
}
