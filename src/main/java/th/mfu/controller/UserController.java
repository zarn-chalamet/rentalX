package th.mfu.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import th.mfu.dto.PasswordDto;
import th.mfu.dto.UserDto;
import th.mfu.model.User;
import th.mfu.service.UserService;

import javax.transaction.Transactional;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register1";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("message", "Registered Successfully!");
        return "register1";
    }

    @GetMapping("/login")
    public String login() {
        return "login-form";
    }

    @GetMapping("user-page")
    public String userPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }
    @GetMapping("/profile")
    public String showProfile(@AuthenticationPrincipal UserDetails userDetails,Model model){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        model.addAttribute("user",user);
        return "profile";
    }
    @GetMapping("/profile-nyl")
    public String showProfileNyl(@AuthenticationPrincipal UserDetails userDetails,Model model){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        model.addAttribute("user",user);
        return "profile-nyl";
    }

    @GetMapping("/edit-profile")
    public String editProfile(Model model){
        model.addAttribute("updateUser",new UserDto());
        return "edit-page";
    }

    @GetMapping("/edit-nyl")
    public String editNyl(Model model){
        model.addAttribute("updateUser",new UserDto());
        return "edit-nyl";
    }
    @Transactional
    @PostMapping("/edit-profile")
    public String saveProfile(@AuthenticationPrincipal UserDetails userDetails,
                              @ModelAttribute("updateUser") UserDto updateUser){
        String email = userDetails.getUsername();
        User currentUser = userService.findByEmail(email);
        userService.updateUserInfo(currentUser,updateUser);
        return "redirect:/profile";
    }

    @GetMapping("/change-password")
    public String changePassword(Model model){
        model.addAttribute("passwordDto",new PasswordDto());
        return "change-password-page";
    }
    @Transactional
    @PostMapping("/change-password")
    public String savePassword(@AuthenticationPrincipal UserDetails userDetails,
                               @ModelAttribute("passwordDto") PasswordDto passwordDto,
                               Model model){
        System.out.println("---------------------------------------------------------------");
        System.out.println(passwordDto.getCurrentPassword());
        System.out.println(passwordDto.getNewPassword());
        System.out.println(passwordDto.getConfirmPassword());
        System.out.println("---------------------------------------------------------------");

        String email = userDetails.getUsername();
        User currentUser = userService.findByEmail(email);
        if(passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())){
            System.out.println("passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword()) = "+
                    passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword()));
            System.out.println("currentPassword from Authentication " + currentUser.getPassword());
            System.out.println("currentPassword from Authentication " + passwordEncoder.encode(passwordDto.getCurrentPassword()));
            if(userService.checkPassword(currentUser,passwordDto.getCurrentPassword())){

                System.out.println("userService.checkPassword(currentUser,passwordDto.getCurrentPassword()) = "+
                        userService.checkPassword(currentUser,passwordDto.getCurrentPassword()));
                if (userService.updatePassword(currentUser,
                        passwordDto.getCurrentPassword(),
                        passwordDto.getNewPassword())){
                    model.addAttribute("successMessage", "Password updated successfully.");
                }
            }else{
                System.out.println("this is else ");
                //error message if current password is incorrect!
                model.addAttribute("errorMessage", "Current password is incorrect.");
            }
        }else{
            //error message if retyping password is incorrect!
            model.addAttribute("errorMessage", "Please type the same password with new password");
        }
        return "redirect:/change-password";
    }
}

