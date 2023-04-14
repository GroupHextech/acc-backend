package HexTech.Backend_lV_Fatec_Embraer.exceptionsHandling.dtos;


import lombok.Getter;

@Getter

public class ErrorValidateDTO {
	
	private String field;
	
	private String message;
	
	public ErrorValidateDTO(String field, String message) {
		this.field = field;
		this.message = message;
	}

}
