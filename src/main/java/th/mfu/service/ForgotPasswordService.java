package th.mfu.service;

import org.springframework.ui.Model;
import th.mfu.dto.ForgotPasswordTokenDto;
import th.mfu.model.ForgotPasswordToken;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public interface ForgotPasswordService {
    String generatedToken();
    LocalDateTime expiredTimeRange();
    void sendEmail(String toEmail,String subject,String emailLink) throws MessagingException, UnsupportedEncodingException;
    boolean isExpired(ForgotPasswordTokenDto forgotPasswordTokenDto);
    String checkValidity(ForgotPasswordToken forgotPasswordToken, Model model);

    ForgotPasswordToken save(ForgotPasswordTokenDto forgotPasswordTokenDto);

    ForgotPasswordToken findByToken(String token);
}
