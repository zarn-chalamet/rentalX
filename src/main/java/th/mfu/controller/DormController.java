package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import th.mfu.dto.DormDto;
import th.mfu.dto.ReviewDto;
import th.mfu.dto.UserDto;
import th.mfu.model.Dorm;
import th.mfu.model.User;
import th.mfu.service.DormService;
import th.mfu.service.PhotoService;
import th.mfu.service.ReviewService;
import th.mfu.service.UserService;

import java.io.IOException;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class DormController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private DormService dormService;

    @Autowired
    private UserService userService;

    @Autowired
    private PhotoService photoService;
    @Autowired
    private ReviewService reviewService;

    public DormController(DormService dormService) {
        this.dormService = dormService;
    }

    @GetMapping("/create-dorm")
    public String showCreateDormForm(Model model){
        model.addAttribute("dorm",new DormDto());
        return "dorm-create-form";
    }
    @PostMapping("/create-dorm")
    public String submitDorm(@ModelAttribute("dorm") DormDto dormDto,
                             @AuthenticationPrincipal UserDetails userDetails,
                             @RequestPart("file")MultipartFile[] file){
        try{
            String email = userDetails.getUsername();
            dormDto.setDormPhotos(photoService.uploadPhoto(file));
            System.out.println(userService.findByEmail(email));
            dormDto.setLandlord(userService.findByEmail(email));
            dormService.save(dormDto);
            return "redirect:/show-landlord-dorms";
        }catch (IOException e){
            e.printStackTrace();
            return "dorm-create-form";
        }
    }

    @GetMapping("dorms")
    public String dormList(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        model.addAttribute("dorms",dormService.getAllDorms());
        model.addAttribute("user",userService.findByEmail(email));
        return "dorms-list";
    }

    @GetMapping("dormms")
    public String dormsss(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        model.addAttribute("dorms",dormService.getAllDorms());
        model.addAttribute("user",userService.findByEmail(email));
        return "dorm-list";
    }

    @PostMapping("/dorms/search")
    public String searchDorms(@RequestParam String keyword, Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        model.addAttribute("user",userService.findByEmail(email));
        model.addAttribute("dorms", dormService.findByKeyword(keyword));
        return "dorm-list";
    }
    @GetMapping("/dorms/sort")
    public String sortDorms(@RequestParam("sortBy") String sortBy, Model model,@AuthenticationPrincipal UserDetails userDetails) {
        List<Dorm> sortedDorms;

        switch (sortBy) {
            case "priceLowToHigh":
                sortedDorms = dormService.getDormsSortedByPriceLowToHigh();
                break;
            case "priceHighToLow":
                sortedDorms = dormService.getDormsSortedByPriceHighToLow();
                break;
            case "nameAlphabetically":
                sortedDorms = dormService.getDormsSortedByNameAlphabetically();
                break;
            default:
                sortedDorms = dormService.getAllDorms();
                break;
        }
        String email = userDetails.getUsername();
        model.addAttribute("user",userService.findByEmail(email));
        model.addAttribute("dorms", sortedDorms);
        return "dorm-list";
    }

    @GetMapping("/show-landlord-dorms")
    public String showLandlordDorms(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User landlord = userService.findByEmail(email);
        Long landlordId = landlord.getId();
        model.addAttribute("dorms",dormService.findDormByLandlordId(landlordId));
        return "landlord-dorms";
    }
    @GetMapping("/dorm/{id}")
    public String showEachDorm(Model model,@PathVariable("id") Long dormId){
        model.addAttribute("dorm",dormService.findById(dormId));
        model.addAttribute("review",new ReviewDto());
        model.addAttribute("reviewsInRepo",reviewService.findByDormId(dormId));
        return "show-each-dorm";
    }

    @GetMapping("/dorm/nyl/{id}")
    public String shoEachDorm(Model model,@PathVariable("id") Long dormId){
        model.addAttribute("dorm",dormService.findById(dormId));
        model.addAttribute("review",new ReviewDto());
        model.addAttribute("reviewsInRepo",reviewService.findByDormId(dormId));
        return "show-each-dorm-nyl";
    }

    @GetMapping("test")
    public String test(){
        return "test";
    }

    @GetMapping("/showEachMap/{id}")
    public String showEachMap(Model model,@PathVariable("id") Long dormId){
        model.addAttribute("dorm",dormService.findById(dormId));
        return "show-each-map";
    }

    @GetMapping("/show-map")
    public String showMap(Model model){
        model.addAttribute("dorms",dormService.getAllDorms());
        return "show-map";
    }

    @GetMapping("/updateDorm/{dorm_id}")
    public String updateDorm(Model model,@PathVariable("dorm_id") Long dormId){
        model.addAttribute("dorm",dormService.findById(dormId));
        model.addAttribute("updatedDorm",new DormDto());
        return "update-dorm";
    }
    @PostMapping("/updateDorm/{dorm_id}")
    public String submitUpdatedDorm(Model model,@PathVariable("dorm_id") Long dormId,
                                    @ModelAttribute("updatedDorm") DormDto updateDorm){
        System.out.println("=======================================================================");
        System.out.println(updateDorm.getDormDesc());
        System.out.println(updateDorm.getCity());
        System.out.println(updateDorm.getAmenities());
        System.out.println("=======================================================================");
        dormService.updateDormInfo(dormService.findById(dormId),updateDorm);
        return "redirect:/show-landlord-dorms";
    }

}
