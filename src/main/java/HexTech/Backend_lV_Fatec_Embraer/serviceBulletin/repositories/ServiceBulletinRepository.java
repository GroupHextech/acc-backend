package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity.ServiceBulletin;

@Repository
public interface ServiceBulletinRepository extends JpaRepository<ServiceBulletin, Long>{
		
	ServiceBulletin findByServiceBulletinNameAndServiceBulletinPart(String bulletinName, String bulletinPart);
}

