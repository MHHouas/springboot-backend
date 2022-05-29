package crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.model.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
    
}
