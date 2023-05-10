package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.updateServiceBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.updateServiceBulletin.dto.VictorBurrroBurrroBurroDTO;

@RestController
@RequestMapping(value = "/update/bulletin")
public class UpdateBulletinController {
	@Autowired
	UpdateBulletinService updateBulletinService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> updateBulletinService(@RequestBody  VictorBurrroBurrroBurroDTO teste){
		updateBulletinService.execute(teste.getServiceBulletinUpdateDto(), teste.getChassi_id());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

}
