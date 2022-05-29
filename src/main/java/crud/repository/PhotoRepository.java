package crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.model.Photo;
import crud.model.Sinistre;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findBySinistre(Sinistre sinistre);
}
