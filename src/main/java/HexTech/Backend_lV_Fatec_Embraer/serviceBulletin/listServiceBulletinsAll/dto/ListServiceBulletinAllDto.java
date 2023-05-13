package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.listServiceBulletinsAll.dto;


import javax.validation.constraints.NotNull;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity.ServiceBulletin;
import lombok.Data;

@Data
public class ListServiceBulletinAllDto {

	@NotNull
	private String service_bulletin_name;
	
	@NotNull
	private String service_bulletin_part;

}
