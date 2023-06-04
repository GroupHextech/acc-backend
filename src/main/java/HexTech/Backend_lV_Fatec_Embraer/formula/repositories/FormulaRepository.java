package HexTech.Backend_lV_Fatec_Embraer.formula.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.formula.entity.Formula;
import HexTech.Backend_lV_Fatec_Embraer.item.entity.Item;


@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long>{

	Formula findByItemId(Item item);
}
