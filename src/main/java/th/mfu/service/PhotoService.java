package th.mfu.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import th.mfu.dto.PhotoDto;
import th.mfu.model.Photo;

import java.io.IOException;
import java.util.Set;

public interface PhotoService {
    Photo save(PhotoDto photoDto);

    Set<Photo> uploadPhoto(MultipartFile[] multipartFiles) throws IOException;

    ResponseEntity<byte[]> getPhoto(Long id);
}
