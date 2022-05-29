package crud.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class SinistreDTO {
	
	@Getter @Setter
	private long id;
	
	@Getter @Setter
	private Date dateAccident;

	@Getter @Setter
	private Date dateCreation;
	
	@Getter @Setter
	private String statut;
	
	@Getter @Setter
	private long numeroContrat;
	
}