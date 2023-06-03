package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.listServiceBulletins.dto;


import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ListServiceBulletinsResponse {

	@NotNull
	private String service_bulleti_name;

	@NotNull
	private String status;
	
	@NotNull
	private String part;
	
	private String user;
	
}

