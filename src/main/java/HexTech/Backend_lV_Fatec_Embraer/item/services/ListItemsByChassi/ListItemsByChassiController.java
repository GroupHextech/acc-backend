package HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListItemsResponseDTO;

@RestController
@RequestMapping(value = "/items/list/{chassi}")
public class ListItemsByChassiController {
		
	@Autowired
	ListItemsByChassiService itemsByChassiService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<ListItemsResponseDTO> listItemsByChassy(@PathVariable("chassi") Integer chassi) {
		
		ListItemsResponseDTO listItems = itemsByChassiService.execute(chassi);
		
		return ResponseEntity.status(HttpStatus.OK).body(listItems);
	}

}
