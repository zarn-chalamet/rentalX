package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import th.mfu.dto.ReviewDto;
import th.mfu.model.Dorm;
import th.mfu.model.User;
import th.mfu.service.DormService;
import th.mfu.service.ReviewService;
import th.mfu.service.UserService;

import javax.sound.sampled.ReverbType;
import java.time.LocalDateTime;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private DormService dormService;
    @Autowired
    private UserService userService;
    @PostMapping("/add-review/{dorm_id}")
    public String writeReview(Model model, @PathVariable("dorm_id") Long dormId,
                              @AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("review") ReviewDto reviewDto){
        Dorm dorm = dormService.findById(dormId);
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        reviewDto.setUser(user);
        reviewDto.setDorm(dorm);
        reviewDto.setTimestamp(LocalDateTime.now());
        reviewService.save(reviewDto);
        return "redirect:/dorm/"+dormId;
    }
    @PostMapping("write-review")
    public String addReview(@ModelAttribute("review") ReviewDto reviewDto){
        reviewService.save(reviewDto);
        return "review";
    }

}
