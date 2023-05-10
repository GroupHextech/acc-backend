package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.updateServiceBulletin.dto;

import java.util.List;

import lombok.Data;

@Data
public class ServiceBulletinChassiDTO {

	private List<ServiceBulletinUpdateDTO> serviceBulletinUpdateDto;
	private Long chassi_id;

}
