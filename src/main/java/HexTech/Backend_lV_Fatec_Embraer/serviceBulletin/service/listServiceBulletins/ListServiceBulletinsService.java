package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.listServiceBulletins;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity.ServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.repositories.ServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.listServiceBulletins.dto.ListServiceBulletinsResponse;

@Service
public class ListServiceBulletinsService implements ListServiceBulletinsImpl {

	@Autowired
	private ServiceBulletinRepository serviceBulletinRepository;

	@Autowired
	private ChassiServiceBulletinRepository chassiServiceBulletinRepository;

	@PreAuthorize("hasRole('EDITOR')" + "|| hasRole('ADM')")	
	public List<ListServiceBulletinsResponse> execute(Long chassiId) {
		
		Chassis chassis = new Chassis();
		chassis.setChassiId(chassiId);
		
		List<ChassiServiceBulletin> serviceBulletins = chassiServiceBulletinRepository.findByChassiId(chassis);

		if(serviceBulletins == null) {
			throw new Error("BulletinsNotExist");
		}

		List<ListServiceBulletinsResponse> bulletinsResponse = new ArrayList<>();

		for (ChassiServiceBulletin serviceBulletin : serviceBulletins) {
			
			ServiceBulletin bulletins = serviceBulletinRepository.findById(serviceBulletin.getServiceBulletinId().getServiceBulletinId()).orElse(null);
			
			ListServiceBulletinsResponse listServiceBulletinsResponse = new ListServiceBulletinsResponse();
			listServiceBulletinsResponse.setService_bulleti_name(bulletins.getServiceBulletinName());
			listServiceBulletinsResponse.setStatus(serviceBulletin.getServiceBulletinStatus());
			listServiceBulletinsResponse.setPart(bulletins.getServiceBulletinPart());
			bulletinsResponse.add(listServiceBulletinsResponse);
		}

		return bulletinsResponse;
	}

}
