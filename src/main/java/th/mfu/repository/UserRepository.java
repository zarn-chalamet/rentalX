package th.mfu.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import th.mfu.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail (String email);
    @Modifying
    @Query("UPDATE User u SET u.userName=?2 WHERE u.id=?1")
    void updateUserName(Long id, String userName);
    @Modifying
    @Query("UPDATE User u SET u.password=?3 WHERE u.id=?1 AND u.password=?2")
    int updatePassword(Long userId, String currentPassword, String newPassword);
}