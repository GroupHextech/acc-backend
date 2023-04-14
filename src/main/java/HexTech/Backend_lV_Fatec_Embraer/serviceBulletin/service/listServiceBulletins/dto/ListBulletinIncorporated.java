package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.listServiceBulletins.dto;


import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import lombok.Data;

@Data
public class ListBulletinIncorporated {

	@NotNull
	private Long service_bulletin_id;

	@NotNull
	private String service_bulleti_name;

	@NotNull
	private Timestamp service_bulletin_register;

	@NotNull
	private String status;

	private String service_bulletin_part;

	@NotNull
	private Chassis chassi_id;

}