package crud.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import crud.dto.PhotoDTO;
import crud.service.PhotoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sinistres/photos")
public class PhotoController {

    @Autowired
	PhotoService photoService;

	@PostMapping("/{id}")
	public ResponseEntity<?> uplaodPhoto(@RequestParam("photoFile") MultipartFile file, @PathVariable Long id) throws IOException {
		photoService.uplaodPhoto(file,id);
		return ResponseEntity.ok(null);
	}

    @GetMapping("/{id}")
	public List<PhotoDTO> getPhotos(@PathVariable Long id) throws IOException {
		return photoService.getPhotos(id);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePhoto(@PathVariable Long id){
		return ResponseEntity.ok(photoService.deletePhoto(id));
	}

}
