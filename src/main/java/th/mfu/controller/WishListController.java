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
import th.mfu.service.DormService;
import th.mfu.service.UserService;
import th.mfu.service.WishListService;

import javax.transaction.Transactional;

@Controller
public class WishListController {
    @Autowired
    private DormService dormService;

    @Autowired
    private UserService userService;

    @Autowired
    private WishListService wishListService;
//    @GetMapping("/add-wishList/{dorm_id}")
//    public String addToWishList(@PathVariable("dorm_id") Long dorm_id, Model model){
//        model.addAttribute("dorm",dormService.findById(dorm_id));
//        return "redirect:/dorms";
//    }

    @GetMapping("/add-wishList/{dorm_id}")
    public String pushToWishList(@PathVariable("dorm_id") Long dorm_id,
                                 @AuthenticationPrincipal UserDetails userDetails){

        String email = userDetails.getUsername();
        WishListDto wishListDto = new WishListDto(userService.findByEmail(email),dormService.findById(dorm_id));
        System.out.println("---------------------------------------------------------");
        System.out.println(userService.findByEmail(email));
        System.out.println(dormService.findById(dorm_id));
        System.out.println("---------------------------------------------------------");
        System.out.println(wishListDto);
        wishListService.save(wishListDto);
        return "redirect:/dorms";
//        String email = userDetails.getUsername();
//        User curretnUser = userService.findByEmail(email);
//        Long currentUserId = curretnUser.getId();
//        if(wishListService.findByUserIdAndDormId(currentUserId,dorm_id) == null){
//            wishListService.removeFromWishList();
//            return
//        }else{
//
//            WishListDto wishListDto = new WishListDto(curretnUser,dormService.findById(dorm_id));
//            wishListService.save(wishListDto);
//        }
    }


}
