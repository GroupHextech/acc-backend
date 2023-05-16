package HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassiByItems;

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
@RequestMapping(value = "/item/listchassi/{item}")
@CrossOrigin
public class ListChassisByItemController {

	@Autowired
	ListChassisByItemService byItemService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Long>> listChassisByItem(@PathVariable("item") String item){
		System.out.println("bateu aqui");
		List<Long> chassisIds = byItemService.execute(item);
		System.out.println("bateu aqui 2");

		return ResponseEntity.status(HttpStatus.OK).body(chassisIds);
		
	}
}
