package crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "photos")
@NoArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
	private Long id;

	@Column(name = "name")
    @Getter @Setter
	private String name;

	@Column(name = "type")
    @Getter @Setter
	private String type;

	@Column(name = "picByte", length = 1000)
    @Getter @Setter
	private byte[] picByte;

    public Photo(String name, String type, byte[] picByte, Sinistre sinistre) {
		this.name = name;
		this.type = type;
		this.picByte = picByte;
		this.sinistre = sinistre;
	}

	@ManyToOne()
	@Getter @Setter
	private Sinistre sinistre;

}
