package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.listServiceBulletinsAll;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.listServiceBulletinsAll.dto.ListServiceBulletinAllDto;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.repositories.ServiceBulletinRepository;


@Service
public class ListServiceBulletinsAllService {

	@Autowired
	ServiceBulletinRepository serviceBulletinRepository;
	
	public List<ListServiceBulletinAllDto> execute() {
		
		//List<String> listServiceBulletin = serviceBulletinRepository.findDistinctByServiceBulletinName();
		
		List<ListServiceBulletinAllDto> listServiceBulletinsAllDto = new ArrayList<ListServiceBulletinAllDto>();
		
		//for (String bulletin: listServiceBulletin) {
			ListServiceBulletinAllDto listServiceBulletinAllDto = new ListServiceBulletinAllDto();
		//	listServiceBulletinAllDto.setService_bulletin_name(bulletin);
			listServiceBulletinsAllDto.add(listServiceBulletinAllDto);
	//	}
		
		return listServiceBulletinsAllDto;
			
	}
	

}
