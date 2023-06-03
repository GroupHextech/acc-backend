package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.listServiceBulletinsAll;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity.ServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.listServiceBulletinsAll.dto.ListServiceBulletinAllDto;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.repositories.ServiceBulletinRepository;


@Service
public class ListServiceBulletinsAllService {

	@Autowired
	ServiceBulletinRepository serviceBulletinRepository;
	
	@PreAuthorize("hasRole('EDITOR')" + "|| hasRole('ADM')")	
	public List<ListServiceBulletinAllDto> execute() {
		
		List<ServiceBulletin> listServiceBulletin = serviceBulletinRepository.findAll();
		
		List<ListServiceBulletinAllDto> listServiceBulletinsAllDto = new ArrayList<ListServiceBulletinAllDto>();
		
		for (ServiceBulletin bulletin: listServiceBulletin) {
			ListServiceBulletinAllDto listServiceBulletinAllDto = new ListServiceBulletinAllDto();
			listServiceBulletinAllDto.setService_bulletin_name(bulletin.getServiceBulletinName());
			listServiceBulletinAllDto.setService_bulletin_part(bulletin.getServiceBulletinPart());
			listServiceBulletinAllDto.setUser(bulletin.getUserRegister().getUserUsername());
			listServiceBulletinsAllDto.add(listServiceBulletinAllDto);
		}
		
		return listServiceBulletinsAllDto;
			
	}
	

}
