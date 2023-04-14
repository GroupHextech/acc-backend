package HexTech.Backend_lV_Fatec_Embraer.condition.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.condition.entity.Condition;


@Repository
public interface conditionRepository extends JpaRepository<Condition, Long> {

}
