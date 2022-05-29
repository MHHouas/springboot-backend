package crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utilisateurs")
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private long id;

    @Column(name = "email")
    @Getter @Setter
	private String email;

    @Column(name = "password")
    @Getter @Setter
	private String password;

    @Column(name = "nom")
    @Getter @Setter
	private String nom;

}