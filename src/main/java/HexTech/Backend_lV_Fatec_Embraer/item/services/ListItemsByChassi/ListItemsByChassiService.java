package HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionMessage.ItemsBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.formula.entity.Formula;
import HexTech.Backend_lV_Fatec_Embraer.formula.repositories.FormulaRepository;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListApplicable;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListIncorporated;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListItemsResponseDTO;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListNotApplicable;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.util.VerifyItems;

@Service
public class ListItemsByChassiService {

	@Autowired
	ChassiServiceBulletinRepository chassiServiceBulletinRepository;
	@Autowired
	FormulaRepository formulaRepository;
	@Autowired
	VerifyItems verifyItems;

	@PreAuthorize("hasRole('PILOT')" + "|| hasRole('EDITOR')" + "|| hasRole('ADM')")
	public ListItemsResponseDTO execute(Long chassiId) {

		Chassis chassis = new Chassis();
		Long chassi = Long.valueOf(chassiId);
		chassis.setChassiId(chassi);

		ListItemsResponseDTO listItemsResponseDTOs = new ListItemsResponseDTO();

		List<ListIncorporated> incorporated = new ArrayList<>();

		List<ListApplicable> applicable = new ArrayList<>();

		List<String> bulletinsNames = new ArrayList<>();

		List<ChassiServiceBulletin> serviceBulletins = chassiServiceBulletinRepository.findByChassiId(chassis);

		List<Formula> formulas = formulaRepository.findAll();

		if (serviceBulletins.isEmpty()) {
			throw new Error("ChassiNotExist");
		}

		for (ChassiServiceBulletin bulletin : serviceBulletins) {
			String bulletinName = bulletin.getServiceBulletinId().getServiceBulletinName();
			System.out.println(bulletin.getServiceBulletinId().getServiceBulletinName());
			bulletinsNames.add(bulletinName);
		}

		for (Formula formula : formulas) {
			boolean resultado = verifyItems.items(bulletinsNames, formula.getFormulaDescription());
			if (resultado) {
				ListIncorporated listIncorporated = new ListIncorporated();
				listIncorporated.setName_item(formula.getItemId().getItemName());
				listIncorporated.setStatus("INCORPORATED");
				incorporated.add(listIncorporated);
			} else {
				System.out.println(formula.getItemId().getItemName()+"Deu ruim");
				ListApplicable listApplicable = new ListApplicable();
				listApplicable.setName_item(formula.getItemId().getItemName());
				listApplicable.setStatus("APPLICABLE");
				applicable.add(listApplicable);
			}
		}
		listItemsResponseDTOs.setApplicable(applicable);
		listItemsResponseDTOs.setIncorporated(incorporated);
		return listItemsResponseDTOs;
	}
}

