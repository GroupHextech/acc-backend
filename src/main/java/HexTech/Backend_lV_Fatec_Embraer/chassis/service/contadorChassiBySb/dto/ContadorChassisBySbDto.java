package HexTech.Backend_lV_Fatec_Embraer.chassis.service.contadorChassiBySb.dto;


import java.util.List;

import javax.validation.constraints.NotNull;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListIncorporated;
import HexTech.Backend_lV_Fatec_Embraer.item.services.contagemItens.dto.ChassisBySbDto;
import lombok.Data;

@Data
public class ContadorChassisBySbDto {

	List<ChassisBySbDto> chassis;
	
	private Integer total_chassi;
	
	private Integer count_chassi;
	
	private String serviceBulletin;
	
	private String part;
	
}

