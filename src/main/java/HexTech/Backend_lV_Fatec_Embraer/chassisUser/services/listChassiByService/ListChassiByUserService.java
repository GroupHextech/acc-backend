package HexTech.Backend_lV_Fatec_Embraer.chassisUser.services.listChassiByService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassisUser.entity.ChassisUser;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.repositories.chassisUserRepository;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@Service
public class ListChassiByUserService {
	
	@Autowired
	chassisUserRepository chassisuserRepository;
	
	@PreAuthorize("hasRole('ADM')")	
	public List<String> exec(Long userId){
		
		Users user = new Users();
		user.setUserId(userId);
		
		
		List<String> chassisUser= new ArrayList<>();
		
		ArrayList<ChassisUser> chassiUser =  chassisuserRepository.findByUserId(user);
		
		for(ChassisUser chassi: chassiUser) {
			chassisUser.add(chassi.getChassiId().getChassiId().toString());
		}
		
		
		return chassisUser;
	}
	

}
