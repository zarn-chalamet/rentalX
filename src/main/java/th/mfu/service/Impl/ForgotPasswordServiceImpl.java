package th.mfu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import th.mfu.dto.ForgotPasswordTokenDto;
import th.mfu.model.ForgotPasswordToken;
import th.mfu.repository.ForgotPasswordRepository;
import th.mfu.service.ForgotPasswordService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
    private final int MINUTES = 10;
    @Autowired
    private ForgotPasswordRepository forgotPasswordRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public String generatedToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public LocalDateTime expiredTimeRange() {
        return LocalDateTime.now().plusMinutes(MINUTES);
    }

    @Override
    public void sendEmail(String toEmail, String subject, String emailLink) throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String emailContent = "<p>Hello</p>"
                + "Click the link the below to reset password"
                + "<p><a href=\""+ emailLink + "\">Change My Password</a></p>"
                + "<br>"
                + "Ignore this Email if you did not made the request";
        helper.setText(emailContent, true);
        helper.setFrom("zarnn872@gmail.com", "RentalX customer Support");
        helper.setSubject(subject);
        helper.setTo(toEmail);
        javaMailSender.send(message);
    }

    @Override
    public boolean isExpired(ForgotPasswordTokenDto forgotPasswordTokenDto) {
        return false;
    }

    @Override
    public String checkValidity(ForgotPasswordToken forgotPasswordToken, Model model) {
        return null;
    }

    @Override
    public ForgotPasswordToken save(ForgotPasswordTokenDto forgotPasswordTokenDto) {
        ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken(forgotPasswordTokenDto.getToken(),forgotPasswordTokenDto.getUser(),forgotPasswordTokenDto.getExpiredTime(),forgotPasswordTokenDto.isUsed());
        return forgotPasswordRepository.save(forgotPasswordToken);
    }

    @Override
    public ForgotPasswordToken findByToken(String token) {
        return forgotPasswordRepository.findByToken(token);
    }
}
