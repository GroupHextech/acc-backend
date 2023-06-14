package HexTech.Backend_lV_Fatec_Embraer.chassisUser.services.registerChassiByUser;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.entity.ChassisUser;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.repositories.chassisUserRepository;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@Service
public class RegisterChassiByUserService {
	
	@Autowired
	chassisUserRepository chassisUserRepository;
	
	@PreAuthorize("hasRole('ADM')")	
	public void exec(ArrayList<RegisterDTO> listregisterDTO) {
		for(RegisterDTO registerDTO: listregisterDTO) {
		Chassis chassis = new Chassis();
		chassis.setChassiId(registerDTO.getChassi_id());
		
		Users users = new Users();
		users.setUserId(registerDTO.getUser_id());
		
		ChassisUser chassisUser = new ChassisUser();
		chassisUser.setChassiId(chassis);
		chassisUser.setUserId(users);
		
		chassisUserRepository.save(chassisUser);
		
		}
	}

}
