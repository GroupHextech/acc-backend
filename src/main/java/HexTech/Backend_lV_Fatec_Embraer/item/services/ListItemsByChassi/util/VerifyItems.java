package HexTech.Backend_lV_Fatec_Embraer.item.services.ListItemsByChassi.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VerifyItems {
	
	public Boolean items(List<String>boletins, String formula) {
		// Verifica se a fórmula é uma fórmula simples (sem operadores lógicos)
		if (!formula.contains("and") && !formula.contains("or")) {
			return boletins.contains(formula);
		}

	    // Verifica se a fórmula contém o operador "and"
	    if (formula.contains("and")) {
	        String[] partesFormula = formula.split(" and ");
	        for (String parte : partesFormula) {
	            if (parte.startsWith("(") && parte.endsWith(")")) {
	                parte = parte.substring(1, parte.length() - 1);
	            }
	            if (!items(boletins, parte)) {
	                return false;
	            }
	        }
	        return true;
	    }

	    // Verifica se a fórmula contém o operador "or"
	    if (formula.contains("or")) {
	        String[] partesFormula = formula.split(" or ");
	        for (String parte : partesFormula) {
	            if (parte.startsWith("(") && parte.endsWith(")")) {
	                parte = parte.substring(1, parte.length() - 1);
	            }
	            if (items(boletins, parte)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // Fórmula inválida
	    return false;
	}

}
