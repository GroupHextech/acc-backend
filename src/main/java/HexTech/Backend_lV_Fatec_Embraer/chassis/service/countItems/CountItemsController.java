package HexTech.Backend_lV_Fatec_Embraer.chassis.service.countItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.chassis.service.countItems.dto.CountItemsResponseDTO;

@RestController
@RequestMapping(value = "/graphic/count/itens")
public class CountItemsController {
	
	@Autowired
	CountItemsService countItemsService;
	
	@GetMapping
	public ResponseEntity<List<CountItemsResponseDTO>> handle(){
		List<CountItemsResponseDTO> countItemsResponseDTO = countItemsService.exec();
		
		return ResponseEntity.status(HttpStatus.OK).body(countItemsResponseDTO);
	}

}
