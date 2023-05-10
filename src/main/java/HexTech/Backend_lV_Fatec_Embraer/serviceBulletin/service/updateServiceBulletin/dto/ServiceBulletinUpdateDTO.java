package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.updateServiceBulletin.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ServiceBulletinUpdateDTO {
	@NotNull
	public String bulletin_service_name; 

	@NotNull
	public String part;
	
	@NotNull
	public String status;

}
