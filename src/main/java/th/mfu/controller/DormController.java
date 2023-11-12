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
import th.mfu.dto.UserDto;
import th.mfu.model.Dorm;
import th.mfu.model.User;
import th.mfu.service.DormService;
import th.mfu.service.PhotoService;
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

    public DormController(DormService dormService) {
        this.dormService = dormService;
    }

    @GetMapping("/create-dorm")
    public String showCreateDormForm(Model model){
        DormDto dormDto = new DormDto();
        model.addAttribute("dorm",dormDto);
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
            return "dorms-list";
        }catch (IOException e){
            e.printStackTrace();
            return "dorm-create-form";
        }
    }

    @GetMapping("dorms")
    public String dormList(Model model){
        model.addAttribute("dorms",dormService.getAllDorms());
        return "dorms-list";
    }

    @GetMapping("dormms")
    public String dormsss(Model model){
        model.addAttribute("dorms",dormService.getAllDorms());
        return "dorm-list";
    }

    @PostMapping("/dorms/search")
    public String searchDorms(@RequestParam String keyword, Model model){
        model.addAttribute("dorms", dormService.findByKeyword(keyword));
        return "dorms-list";
    }
    @GetMapping("/dorms/sort")
    public String sortDorms(@RequestParam("sortBy") String sortBy, Model model) {
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

        model.addAttribute("dorms", sortedDorms);
        return "dorms-list";
    }

}
