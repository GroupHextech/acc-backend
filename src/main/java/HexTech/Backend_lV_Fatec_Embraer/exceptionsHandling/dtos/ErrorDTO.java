package HexTech.Backend_lV_Fatec_Embraer.exceptionsHandling.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ErrorDTO {
	
	private String message;
	
	public ErrorDTO(String message) {
		this.message = message;
	}

}
