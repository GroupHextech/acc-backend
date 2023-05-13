package HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto;



import java.util.List;

import lombok.Data;

@Data
public class ListItemsResponseDTO {
	
	List<ListIncorporated> incorporated;
		
	List<ListApplicable> applicable;
	
	
	
}
