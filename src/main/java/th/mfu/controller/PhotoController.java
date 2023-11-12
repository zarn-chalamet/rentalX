package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import th.mfu.service.PhotoService;

@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;
    @GetMapping("/photo/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id){
        return photoService.getPhoto(id);
    }


}
