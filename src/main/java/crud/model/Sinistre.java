package crud.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sinistres")
@NoArgsConstructor
public class Sinistre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private long id;
	
	@Column(name = "date_accident")
	@Getter @Setter
	private Date dateAccident;

	@Column(name = "date_creation")
	@Getter @Setter
	private Date dateCreation;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "statut")
	@Getter @Setter
	private Statut statut;
		
	public Sinistre(Contrat contrat, Date dateAccident, Date dateCreation, Statut statut) {
		this.contrat=contrat;
		this.dateAccident = dateAccident;
		this.dateCreation = dateCreation;
		this.statut = statut;
	}
	
	@ManyToOne()
	@Getter @Setter
	private Contrat contrat;
	
}