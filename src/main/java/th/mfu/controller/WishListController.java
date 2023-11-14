package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import th.mfu.dto.WishListDto;
import th.mfu.model.User;
import th.mfu.model.WishList;
import th.mfu.service.DormService;
import th.mfu.service.UserService;
import th.mfu.service.WishListService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class WishListController {
    @Autowired
    private DormService dormService;

    @Autowired
    private UserService userService;

    @Autowired
    private WishListService wishListService;

    @GetMapping("/wishlists")
    public String showWishList(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        Long userId = user.getId();
        System.out.println(userId);
        List<WishList> wishLists = wishListService.findByUserId(userId);
        model.addAttribute("wishlists",wishLists);
        return "wishlists";
    }

    @Transactional
    @GetMapping("/add-wishList/{dorm_id}")
    public String pushToWishList(@PathVariable("dorm_id") Long dorm_id,
                                 @AuthenticationPrincipal UserDetails userDetails){

        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        Long userId = user.getId();
        if(wishListService.findByUserIdAndDormId(userId,dorm_id) == null){
            WishListDto wishListDto = new WishListDto(userService.findByEmail(email),dormService.findById(dorm_id));
            System.out.println(wishListDto);
            wishListService.save(wishListDto);
            return "redirect:/dorms";
        }else{
            wishListService.deleteFromWishList(userId,dorm_id);
            return "redirect:/dorms";
        }
    }
}
