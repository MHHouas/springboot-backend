package crud.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ContratDTO {

	@Getter @Setter
	private long numero;
	
	@Getter @Setter
	private Date dateDebut;

	@Getter @Setter
	private Date dateFin;
	
	@Getter @Setter
	private String nomAssure;

	@Getter @Setter
	private String matriculeVehicule;

}
