package crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.model.Sinistre;

@Repository
public interface SinistreRepository extends JpaRepository<Sinistre, Long>{

}
