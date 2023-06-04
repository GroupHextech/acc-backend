package HexTech.Backend_lV_Fatec_Embraer.chassis.service.countItems;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassis.repositories.ChassisRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassis.service.countItems.dto.CountItemsResponseDTO;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.formula.entity.Formula;
import HexTech.Backend_lV_Fatec_Embraer.formula.repositories.FormulaRepository;
import HexTech.Backend_lV_Fatec_Embraer.item.repositories.ItemRepository;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.util.VerifyItems;

@Service
public class CountItemsService {

	@Autowired
	ChassisRepository chassisRepository;

	@Autowired
	ChassiServiceBulletinRepository serviceBulletinRepository;

	@Autowired
	FormulaRepository formulaRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	VerifyItems verifyItems;

	@PreAuthorize("hasRole('ADM')")
	public List<CountItemsResponseDTO> exec() {
		List<CountItemsResponseDTO> countItemsResponseDTOs = new ArrayList<>();

		List<Chassis> chassis = chassisRepository.findAll();

		List<Formula> formulas = formulaRepository.findAll();
		
		Integer quantity = 0;
		for (Formula formula : formulas) {
			CountItemsResponseDTO countItemsResponseDTO = new CountItemsResponseDTO();
			countItemsResponseDTO.setItem(formula.getItemId().getItemName());
			for (Chassis chassi : chassis) {
				List<String> bulletinsNames = new ArrayList<>();
				List<ChassiServiceBulletin> bulletins = serviceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin bulletin : bulletins) {
					String bulletinName = bulletin.getServiceBulletinId().getServiceBulletinName();
					bulletinsNames.add(bulletinName);
				}
				Boolean containItem = verifyItems.items(bulletinsNames, formula.getFormulaDescription());
				if(containItem) {
					quantity++;
				}
			}
			
			countItemsResponseDTO.setQuantity(quantity.toString());
			countItemsResponseDTOs.add(countItemsResponseDTO);
		}

		return countItemsResponseDTOs;
	}

}
