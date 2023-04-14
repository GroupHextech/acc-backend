package HexTech.Backend_lV_Fatec_Embraer.usersb.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.usersb.entity.UserServiceBulletin;

@Repository
public interface UserServiceBulletinRepository extends JpaRepository<UserServiceBulletin, Long>{
	
}
