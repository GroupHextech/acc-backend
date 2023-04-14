package HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;

@Repository
public interface ChassiServiceBulletinRepository  extends JpaRepository<ChassiServiceBulletin, Long>{

	List<ChassiServiceBulletin> findByChassiId(Chassis chassi);
}
