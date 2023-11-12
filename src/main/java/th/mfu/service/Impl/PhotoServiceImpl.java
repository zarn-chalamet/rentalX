package th.mfu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import th.mfu.dto.PhotoDto;
import th.mfu.model.Photo;
import th.mfu.repository.PhotoRepository;
import th.mfu.service.PhotoService;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public Photo save(PhotoDto photoDto) {
        Photo photo = new Photo(photoDto.getImageData(),photoDto.getFileName(),photoDto.getMimeType());
        return photoRepository.save(photo);
    }

    @Override
    public Set<Photo> uploadPhoto(MultipartFile[] multipartFiles) throws IOException {
        Set<Photo> photos = new HashSet<>();
        for(MultipartFile file : multipartFiles){
            Photo photo = new Photo(
                    file.getBytes(),
                    file.getOriginalFilename(),
                    file.getContentType()
            );
            photoRepository.save(photo);
            photos.add(photo);
        }
        return photos;
    }

    @Override
    public ResponseEntity<byte[]> getPhoto(Long id) {

        Optional<Photo> imageEntityOptional = photoRepository.findById(id);
        if (imageEntityOptional.isPresent()) {
            Photo photo = imageEntityOptional.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(photo.getImageData());
        }
        return ResponseEntity.notFound().build();

    }
}
