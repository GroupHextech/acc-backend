package HexTech.Backend_lV_Fatec_Embraer.formula.service.registerFormulaAndItem;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.formula.entity.Formula;
import HexTech.Backend_lV_Fatec_Embraer.formula.repositories.FormulaRepository;
import HexTech.Backend_lV_Fatec_Embraer.formula.service.registerFormulaAndItem.dto.RegisterFormulaAndItemDto;
import HexTech.Backend_lV_Fatec_Embraer.item.entity.Item;
import HexTech.Backend_lV_Fatec_Embraer.item.repositories.ItemRepository;
import HexTech.Backend_lV_Fatec_Embraer.securityconfig.UserSession;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@Service
@Transactional
public class RegisterFormulaAndItemService {

	@Autowired
	private FormulaRepository formulaRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	UserSession userSession;

	public void execute(RegisterFormulaAndItemDto registerFormulaAndItemDto) {
		Users user = userSession.userLoged();
		
		Item existItem = itemRepository.findByItemName(registerFormulaAndItemDto.getItem());
		if (existItem == null) {
			System.out.println(1);
			Item newItem = new Item();
			newItem.setItemName(registerFormulaAndItemDto.getItem());
			Item itemRegistered = itemRepository.save(newItem);
			System.out.println(2);
			Formula newFormula = new Formula();
			newFormula.setFormulaDescription(registerFormulaAndItemDto.getFormula_desc());
			newFormula.setItemId(itemRegistered);
			newFormula.setUser(user);
			formulaRepository.save(newFormula);
		}
		else {
			Formula newFormula = new Formula();
			newFormula.setFormulaDescription(registerFormulaAndItemDto.getFormula_desc());
			newFormula.setItemId(existItem);
			newFormula.setUser(user);
			formulaRepository.save(newFormula);
		}
	}
}
