package HexTech.Backend_lV_Fatec_Embraer.item.services.contagemItens;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassis.repositories.ChassisRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.formula.entity.Formula;
import HexTech.Backend_lV_Fatec_Embraer.formula.repositories.FormulaRepository;
import HexTech.Backend_lV_Fatec_Embraer.item.repositories.ItemRepository;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListApplicable;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListIncorporated;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.dto.ListItemsResponseDTO;
import HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.util.VerifyItems;
import HexTech.Backend_lV_Fatec_Embraer.item.services.contagemItens.dto.ContagemItensByChassiDto;

@Service
public class ContagemItensByChassiService {

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	ChassisRepository chassiRepository;
	@Autowired
	ChassiServiceBulletinRepository chassiServiceBulletinRepository;
	@Autowired
	FormulaRepository formulaRepository;
	@Autowired
	VerifyItems verifyItems;

	public List<ContagemItensByChassiDto> execute() {

		List<Chassis> listChassis = chassiRepository.findAll();
		List<ListIncorporated> incorporated = new ArrayList<>();
		List<Formula> formulas = formulaRepository.findAll();

		if (listChassis == null || listChassis.isEmpty()) {
			throw new Error("ChassiNotExist");
		}

		List<ContagemItensByChassiDto> contagemItensByChassiDtos = new ArrayList<ContagemItensByChassiDto>();

		for (Chassis chassi : listChassis) {
			List<ChassiServiceBulletin> serviceBulletins = chassiServiceBulletinRepository.findByChassiId(chassi);
			List<String>bulletinsNames = new ArrayList<>();
			for (ChassiServiceBulletin bulletin : serviceBulletins) {
				String bulletinName = bulletin.getServiceBulletinId().getServiceBulletinName();
				bulletinsNames.add(bulletinName);
			}
			for (Formula formula : formulas) {
				boolean resultado = verifyItems.items(bulletinsNames, formula.getFormulaDescription());
				if (resultado) {
					ListIncorporated listIncorporated = new ListIncorporated();
					listIncorporated.setName_item(formula.getItemId().getItemName());
					listIncorporated.setStatus("INCORPORATED");
					incorporated.add(listIncorporated);
				}
			}
			Integer countItens = incorporated.size();
			ContagemItensByChassiDto contagemItens = new ContagemItensByChassiDto();
			contagemItens.setChassi(chassi.getChassiId());
			contagemItens.setCount_item(countItens);
			contagemItensByChassiDtos.add(contagemItens);
			
		}
		return contagemItensByChassiDtos;
	}
}
