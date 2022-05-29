package crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.dto.SinistreDTO;
import crud.service.SinistreService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sinistres")
public class SinistreController {

	@Autowired
	private SinistreService sinistreService;
	
	@GetMapping
	public List<SinistreDTO> getAllSinistres(){
		return sinistreService.findAll();
	}		
	
	@PostMapping
	public SinistreDTO createSinistre(@RequestBody SinistreDTO sinistre) {
		return sinistreService.createSinistre(sinistre);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SinistreDTO> getSinistreById(@PathVariable Long id) {
		return ResponseEntity.ok(sinistreService.getSinistreById(id));
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<SinistreDTO> updateSinistre(@PathVariable Long id, @RequestBody SinistreDTO sinistreDetails){
		return ResponseEntity.ok(sinistreService.updateSinistre(id, sinistreDetails));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSinistre(@PathVariable Long id){
		return ResponseEntity.ok(sinistreService.deleteSinistre(id));
	}
	
}
