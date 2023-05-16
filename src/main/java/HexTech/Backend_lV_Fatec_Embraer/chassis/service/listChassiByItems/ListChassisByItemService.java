package HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassiByItems;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassis.repositories.ChassisRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassiByItems.util.ChassiContainItem;

@Service
public class ListChassisByItemService {

	@Autowired
	ChassisRepository chassisRepository;

	@Autowired
	ChassiContainItem chassiContainItem;

	@PreAuthorize("hasRole('PILOT')" + "|| hasRole('EDITOR')" + "|| hasRole('ADM')")
	public List<Long> execute(String itemName) {
		List<Chassis> chassis = chassisRepository.findAll();

		List<Long> chassisIds = new ArrayList<>();

		for (Chassis chassiId : chassis) {
			chassisIds.add(chassiId.getChassiId());
		}
		List<Long> idContain = chassiContainItem.containItem(chassisIds, itemName);

		return idContain;

	}

}
