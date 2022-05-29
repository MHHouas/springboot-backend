package crud.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import crud.dto.PhotoDTO;
import crud.exception.ResourceNotFoundException;
import crud.model.Photo;
import crud.repository.PhotoRepository;
import crud.repository.SinistreRepository;

@Service
public class PhotoService {
    
    @Autowired
	PhotoRepository photoRepository;

    @Autowired
    SinistreRepository sinistreRepository;

	public void uplaodPhoto(MultipartFile file, Long idSinistre) throws IOException {
		System.out.println("Original Photo Byte Size - " + file.getBytes().length);
		Photo photo = new Photo(file.getOriginalFilename(), file.getContentType(),compressZLib(file.getBytes()),sinistreRepository.getOne(idSinistre));
		photoRepository.save(photo);
	}

    public List<PhotoDTO> getPhotos(Long idSinistre) throws IOException {
		final List<Photo> retrievedPhotos = photoRepository.findBySinistre(sinistreRepository.getOne(idSinistre));
		List<PhotoDTO> photos = new ArrayList();
        for (Photo p : retrievedPhotos) {
        PhotoDTO dto = new PhotoDTO(p.getId(),p.getName(), p.getType(),decompressZLib(p.getPicByte()),p.getSinistre().getId());
		photos.add(dto);
        }
        return photos;
	}

	public static byte[] compressZLib(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Photo Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	public static byte[] decompressZLib(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

    public Map<String, Boolean> deletePhoto(Long id){
		Photo s = photoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de sinistre n°" + id));
		photoRepository.delete(s);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
    
}
