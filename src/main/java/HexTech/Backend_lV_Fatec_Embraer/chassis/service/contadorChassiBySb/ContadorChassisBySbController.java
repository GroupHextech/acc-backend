package HexTech.Backend_lV_Fatec_Embraer.chassis.service.contadorChassiBySb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.chassis.service.contadorChassiBySb.dto.ContadorChassisBySbDto;

@RestController
@RequestMapping(value = "/chassi/countchassi/{sb}/{part}")
public class ContadorChassisBySbController {
	
	@Autowired
	ContadorChassisBySbService contadorChassisBySbService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<ContadorChassisBySbDto>contadorChassisBySb(@PathVariable("sb") String sbName, @PathVariable("part") String part){
		
		ContadorChassisBySbDto contadorChassisBySbDto = contadorChassisBySbService.execute(sbName, part);

		return ResponseEntity.status(HttpStatus.OK).body(contadorChassisBySbDto);
		
	}
}
