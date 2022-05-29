package crud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.dto.ContratDTO;
import crud.exception.ResourceNotFoundException;
import crud.model.Contrat;
import crud.repository.ContratRepository;

@Service
public class ContratService {
    
    @Autowired
    private ContratRepository contratRepository;  

    public List<ContratDTO> getAllContrats(){
		List<Contrat> contrats = contratRepository.findAll();
        List<ContratDTO> dtos = new ArrayList();
        for (Contrat s : contrats){
            dtos.add(new ContratDTO(s.getNumero(),s.getDateDebut(),s.getDateFin(),s.getNomAssure(),s.getMatriculeVehicule()));
        }
        return dtos;
	}

  public ContratDTO createContrat(ContratDTO contratDTO){
    contratRepository.save(new Contrat(contratDTO.getNumero(),contratDTO.getDateDebut(),contratDTO.getDateFin(),contratDTO.getNomAssure(),contratDTO.getMatriculeVehicule()));
    return contratDTO;
  }

  public ContratDTO getContratById(Long id) {
		Contrat s = contratRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de contrat n°" + id));
        ContratDTO contrat = new ContratDTO(id,s.getDateDebut(),s.getDateFin(),s.getNomAssure(),s.getMatriculeVehicule());
		return contrat;
	}

  public ContratDTO updateContrat(Long id, ContratDTO contratDetails){
		Contrat s = contratRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de contrat n°" + id));
		s.setDateDebut(contratDetails.getDateDebut());
		s.setDateFin(contratDetails.getDateFin());
		s.setNomAssure(contratDetails.getNomAssure());
        s.setMatriculeVehicule(contratDetails.getMatriculeVehicule());
		contratRepository.save(s);
		return contratDetails;
	}
	
	public Map<String, Boolean> deleteContrat(Long id){
		Contrat s = contratRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de contrat n°" + id));
		contratRepository.delete(s);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
    
}
