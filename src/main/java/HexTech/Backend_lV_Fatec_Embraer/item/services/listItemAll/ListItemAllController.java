package HexTech.Backend_lV_Fatec_Embraer.item.services.listItemAll;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.item.services.listItemAll.dto.ListItemAllDto;


@RestController
@RequestMapping(value="/item/listall")
public class ListItemAllController {

	@Autowired
	ListItemAllService listItemAllService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<ListItemAllDto>> listItemAll(){
		List<ListItemAllDto> listItemAllDto = listItemAllService.execute();
		
		return ResponseEntity.status(HttpStatus.OK).body(listItemAllDto);	
	}
}
