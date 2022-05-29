package crud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.dto.SinistreDTO;
import crud.exception.ResourceNotFoundException;
import crud.model.Sinistre;
import crud.model.Statut;
import crud.repository.ContratRepository;
import crud.repository.SinistreRepository;

@Service
public class SinistreService {

    @Autowired
    private SinistreRepository sinistreRepository;

    @Autowired
    private ContratRepository contratRepository;  

    public List<SinistreDTO> findAll(){
		List<Sinistre> sinistres = sinistreRepository.findAll();
    List<SinistreDTO> dtos = new ArrayList();
    for (Sinistre s : sinistres){
      dtos.add(new SinistreDTO(s.getId(),s.getDateAccident(),s.getDateCreation(),s.getStatut().toString(),s.getContrat().getNumero()));
    }
    return dtos;
	}

  public SinistreDTO createSinistre(SinistreDTO sinistreDTO){
    Sinistre s = sinistreRepository.save(new Sinistre(contratRepository.getOne(sinistreDTO.getNumeroContrat()),sinistreDTO.getDateAccident(),sinistreDTO.getDateCreation(), Statut.valueOf(sinistreDTO.getStatut())));
    sinistreDTO.setId(s.getId());
    return sinistreDTO;
  }

  public SinistreDTO getSinistreById(Long id) {
		Sinistre s = sinistreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de sinistre n°" + id));
    SinistreDTO sinistre = new SinistreDTO(id,s.getDateAccident(),s.getDateCreation(),s.getStatut().toString(),s.getContrat().getNumero());
		return sinistre;
	}

  public SinistreDTO updateSinistre(Long id, SinistreDTO sinistreDetails){
		Sinistre s = sinistreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de sinistre n°" + id));
    s.setContrat(contratRepository.getOne(sinistreDetails.getNumeroContrat()));
		s.setDateAccident(sinistreDetails.getDateAccident());
		s.setDateCreation(sinistreDetails.getDateCreation());
		s.setStatut(Statut.valueOf(sinistreDetails.getStatut()));
		sinistreRepository.save(s);
		return sinistreDetails;
	}
	
	public Map<String, Boolean> deleteSinistre(Long id){
		Sinistre s = sinistreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de sinistre n°" + id));
		sinistreRepository.delete(s);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
