package HexTech.Backend_lV_Fatec_Embraer.exceptionsHandling.dtos;


import lombok.Getter;

@Getter
public class ErrorInternalServerDTO {
	
	public ErrorInternalServerDTO(String message) {
		this.message = message;
	}

	private String message;
	
	

}
