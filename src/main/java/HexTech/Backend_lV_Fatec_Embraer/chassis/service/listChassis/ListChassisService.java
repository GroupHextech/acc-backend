package HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassis;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassis.repositories.ChassisRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassis.dto.ListChassisDto;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.entity.ChassisUser;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.repositories.chassisUserRepository;
import HexTech.Backend_lV_Fatec_Embraer.securityconfig.UserSession;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;


@Service
public class ListChassisService  {

	@Autowired
	ChassisRepository chassisRepository;
	
	@Autowired
	UserSession session;
	
	@Autowired
	chassisUserRepository chassisUserRepository;
	
	@PreAuthorize("hasRole('ADM')")	
	public List<ListChassisDto> execute() {
		
		Users userLoged = session.userLoged();
		
		List<ChassisUser> listChassis = chassisUserRepository.findByUserId(userLoged);
		
		if (listChassis==null || listChassis.isEmpty()) {
			throw new Error("ChassiNotExist");
		}
		
		List<ListChassisDto> listChassiDto = new ArrayList<ListChassisDto>();
		
		for (ChassisUser chassi: listChassis) {
			ListChassisDto listChassisDto = new ListChassisDto();
			listChassisDto.setChassi_id(chassi.getChassiId().getChassiId());
			listChassiDto.add(listChassisDto);
		}
			
		return listChassiDto;
	}

}
