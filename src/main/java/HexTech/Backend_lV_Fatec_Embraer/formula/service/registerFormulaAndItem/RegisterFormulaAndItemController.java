package HexTech.Backend_lV_Fatec_Embraer.formula.service.registerFormulaAndItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.formula.service.registerFormulaAndItem.dto.RegisterFormulaAndItemDto;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.registerServiceBulletin.RegisterBulletinService;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.registerServiceBulletin.dto.ServiceBulletinRegisterDTO;

@RestController
@RequestMapping(value = "/register/formula")
public class RegisterFormulaAndItemController {

	@Autowired
	RegisterFormulaAndItemService formulaAndItem;
	
	@CrossOrigin
	@PostMapping
 	public ResponseEntity<Void> registerFormulaAndItem(@RequestBody RegisterFormulaAndItemDto registerFormulaAndItemDto){

		formulaAndItem.execute(registerFormulaAndItemDto);
			
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

}
