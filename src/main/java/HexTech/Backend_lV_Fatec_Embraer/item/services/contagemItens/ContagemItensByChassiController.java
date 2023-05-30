package HexTech.Backend_lV_Fatec_Embraer.item.services.contagemItens;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.item.services.contagemItens.dto.ContagemItensByChassiDto;


@RestController
@RequestMapping(value="/item/contagem")
public class ContagemItensByChassiController {

	@Autowired
	ContagemItensByChassiService contagemItensByChassiService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<ContagemItensByChassiDto>> contagemItensByChassiDto() {
	
		List<ContagemItensByChassiDto> countItems = contagemItensByChassiService.execute();
	
		return ResponseEntity.status(HttpStatus.OK).body(countItems);
	}

}
