package HexTech.Backend_lV_Fatec_Embraer.chassisUser.services.listChassiByService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/list/chassi/user/{id}")
@CrossOrigin
public class ListChassiByUserController {
	
	
	@Autowired
	ListChassiByUserService byUserService;
	
	@GetMapping
	public ResponseEntity<List<String>> handle(@PathVariable("id") Long userId){
		
		List<String> listChassisNumbers = byUserService.exec(userId);
		
		return ResponseEntity.status(HttpStatus.OK).body(listChassisNumbers);
		
	}

}
