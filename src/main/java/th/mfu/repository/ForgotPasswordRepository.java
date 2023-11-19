package th.mfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.mfu.model.ForgotPasswordToken;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken,Long> {
    ForgotPasswordToken findByToken(String token);
}
