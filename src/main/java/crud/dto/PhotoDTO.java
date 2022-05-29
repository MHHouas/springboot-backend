package crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class PhotoDTO {
    
    @Getter @Setter
	private Long id;

    @Getter @Setter
	private String name;

    @Getter @Setter
	private String type;

    @Getter @Setter
	private byte[] picByte;

	@Getter @Setter
	private Long idSinistre;

}
