package HexTech.Backend_lV_Fatec_Embraer.chassis.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;


@Repository
public interface ChassisRepository extends JpaRepository<Chassis, Long>{

}
