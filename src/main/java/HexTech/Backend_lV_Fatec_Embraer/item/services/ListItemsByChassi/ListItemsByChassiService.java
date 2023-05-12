package HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListItemsResponseDTO;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.util.ContainsItems;

@Service
public class ListItemsByChassiService {

	@Autowired
	ContainsItems containsItems;
	
	@PreAuthorize("hasRole('PILOT')" + "|| hasRole('EDITOR')" + "|| hasRole('ADM')")	
	public ListItemsResponseDTO execute(Integer chassiId) {
		ListItemsResponseDTO items = containsItems.items(chassiId);

		return items;
	}

}
