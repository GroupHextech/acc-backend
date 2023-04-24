package HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassis.dto;


import java.sql.Timestamp;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
public class ListChassisDto {
	
	@NotNull
	private Long chassi_id;

}
