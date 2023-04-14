package HexTech.Backend_lV_Fatec_Embraer.chassisItem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.chassisItem.entity.ChassisItem;


@Repository
public interface chassisItemRepository extends JpaRepository<ChassisItem, Long> {

}
