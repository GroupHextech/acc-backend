package HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassiByItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@RestController
@RequestMapping(value = "/item/listchassi/{item}")
@CrossOrigin
public class ListChassisByItemController {


	
	@Autowired
	ListChassisByItemService byItemService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Long>> listChassisByItem(@PathVariable("item") String item){
		

		List<Long> chassisIds = byItemService.execute(item);

		return ResponseEntity.status(HttpStatus.OK).body(chassisIds);
		
	}
}
