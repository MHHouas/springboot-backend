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

import crud.dto.ContratDTO;
import crud.service.ContratService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contrats")
public class ContratController {

	@Autowired
	private ContratService contratService;
	
	@GetMapping
	public List<ContratDTO> getAllContrats(){
		return contratService.getAllContrats();
	}		
	
	@PostMapping
	public ContratDTO createContrat(@RequestBody ContratDTO contrat) {
		return contratService.createContrat(contrat);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContratDTO> getContratById(@PathVariable Long id) {
		return ResponseEntity.ok(contratService.getContratById(id));
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<ContratDTO> updateContrat(@PathVariable Long id, @RequestBody ContratDTO contratDetails){
		return ResponseEntity.ok(contratService.updateContrat(id, contratDetails));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContrat(@PathVariable Long id){
		return ResponseEntity.ok(contratService.deleteContrat(id));
	}	
	
}
