package crud.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contrats")
@NoArgsConstructor
@RequiredArgsConstructor
public class Contrat {

    @Id
    @Column(name = "numero")
	@Getter @Setter @NonNull
	private long numero;
	
	@Column(name = "date_debut")
	@Getter @Setter @NonNull
	private Date dateDebut;

	@Column(name = "date_fin")
	@Getter @Setter @NonNull
	private Date dateFin;
	
	@Column(name = "nom_assure")
	@Getter @Setter @NonNull
	private String nomAssure;

    @Column(name = "matricule_vehicule")
	@Getter @Setter @NonNull
	private String matriculeVehicule;

	@OneToMany (mappedBy = "contrat")
	private List<Sinistre> sinistres;

}
