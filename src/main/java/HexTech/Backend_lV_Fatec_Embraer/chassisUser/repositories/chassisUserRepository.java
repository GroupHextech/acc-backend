package HexTech.Backend_lV_Fatec_Embraer.chassisUser.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.chassisUser.entity.ChassisUser;

@Repository
public interface chassisUserRepository extends JpaRepository<ChassisUser, Long>{

}
