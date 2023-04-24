package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.registerServiceBulletin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.registerServiceBulletin.dto.ServiceBulletinRegisterDTO;


@RestController
@RequestMapping(value = "/register/bulletin")
public class RegisterBulletinController {
	
	@Autowired
	RegisterBulletinService bulletinService;
	
	@CrossOrigin
	@PostMapping
 	public ResponseEntity<Void> registerBulletinService(@RequestBody List<ServiceBulletinRegisterDTO> serviceBulletinRegisterDTO){

		bulletinService.execute(serviceBulletinRegisterDTO);
			
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
}