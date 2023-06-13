package HexTech.Backend_lV_Fatec_Embraer.chassisUser.services.registerChassiByUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping(value = "/register/chassi/user")
public class RegisterChassiByUserController {

	
	@Autowired
	RegisterChassiByUserService registerChassiByUserService;
	
	
	@PostMapping
	public ResponseEntity<Void> handle(@RequestBody RegisterDTO registerDTO){
		
		registerChassiByUserService.exec(registerDTO.getChassi_id(), registerDTO.getUser_id());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
