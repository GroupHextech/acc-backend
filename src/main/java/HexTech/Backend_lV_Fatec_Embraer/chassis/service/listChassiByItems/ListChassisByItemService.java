package HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassiByItems;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassis.repositories.ChassisRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassiByItems.util.ChassiContainItem;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.entity.ChassisUser;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.repositories.chassisUserRepository;
import HexTech.Backend_lV_Fatec_Embraer.securityconfig.UserSession;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@Service
public class ListChassisByItemService {

	@Autowired
	ChassisRepository chassisRepository;
	
	@Autowired
	chassisUserRepository chassisUserRepository;
	
	@Autowired
	UserSession session;

	@Autowired
	ChassiContainItem chassiContainItem;

	@PreAuthorize("hasRole('PILOT')" + "|| hasRole('EDITOR')" + "|| hasRole('ADM')")
	public List<Long> execute(String itemName) {
		
		Users user = session.userLoged();
		
		ArrayList<ChassisUser> chassisUsers = chassisUserRepository.findByUserId(user);
		
		List<Long> chassisIds = new ArrayList<>();

		for (ChassisUser chassiId : chassisUsers) {
			chassisIds.add(chassiId.getChassiId().getChassiId());
		}
		List<Long> idContain = chassiContainItem.containItem(chassisIds, itemName);

		return idContain;

	}

}
