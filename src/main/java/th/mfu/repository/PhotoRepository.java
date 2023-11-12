package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.mfu.model.Photo;
@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {

}
