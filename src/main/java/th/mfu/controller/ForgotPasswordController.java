package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.mfu.dto.ForgotPasswordTokenDto;
import th.mfu.model.ForgotPasswordToken;
import th.mfu.model.User;
import th.mfu.repository.ForgotPasswordRepository;
import th.mfu.repository.UserRepository;
import th.mfu.service.ForgotPasswordService;
import th.mfu.service.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserService userService;
    @Autowired
    private ForgotPasswordService forgotPasswordService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ForgotPasswordRepository forgotPasswordRepository;
    @GetMapping("/password-request")
    public String passwordRequest(){
        return "request-password";
    }
    @PostMapping("/password-request")
    public String savePasswordRequest(@RequestParam("username") String email, Model model){
        User user = userService.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "This Email is not registered");
            return "password-request";
        }
        ForgotPasswordTokenDto forgotPasswordTokenDto = new ForgotPasswordTokenDto();
        forgotPasswordTokenDto.setExpiredTime(forgotPasswordService.expiredTimeRange());
        forgotPasswordTokenDto.setToken(forgotPasswordService.generatedToken());
        forgotPasswordTokenDto.setUser(user);
        forgotPasswordTokenDto.setUsed(false);

        forgotPasswordService.save(forgotPasswordTokenDto);

        String emailLink = "http://localhost:8100/reset-password?token=" + forgotPasswordTokenDto.getToken();

//        System.out.println("============================================================================");
//        System.out.println(user.getEmail());
//        System.out.println(emailLink);
//        System.out.println("============================================================================");
        try {
            forgotPasswordService.sendEmail(user.getEmail(), "Password Reset Link", emailLink);
        } catch (UnsupportedEncodingException | MessagingException e) {
            model.addAttribute("error", "Error While Sending email");
            return "password-request";
        }


        return "redirect:/password-request?success";
    }
    @GetMapping("/reset-password")
    public String resetPassword(@Param(value="token") String token, Model model, HttpSession session) {

        session.setAttribute("token", token);
        ForgotPasswordToken forgotPasswordToken = forgotPasswordService.findByToken(token);
        return forgotPasswordService.checkValidity(forgotPasswordToken, model);

    }

    @PostMapping("/reset-password")
    public String saveResetPassword(HttpServletRequest request, HttpSession session, Model model) {
        String password = request.getParameter("password");
        String token = (String)session.getAttribute("token");

        ForgotPasswordToken forgotPasswordToken = forgotPasswordService.findByToken(token);
        User user = forgotPasswordToken.getUser();
        user.setPassword(passwordEncoder.encode(password));
        forgotPasswordToken.setUsed(true);
        userRepository.save(user);
        forgotPasswordRepository.save(forgotPasswordToken);

        model.addAttribute("message", "You have successfuly reset your password");

        return "reset-password";
    }
}
