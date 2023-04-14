package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.listServiceBulletins;


import java.util.List;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.listServiceBulletins.dto.ListServiceBulletinsResponse;

public interface ListServiceBulletinsImpl {
	
	public List<ListServiceBulletinsResponse> execute(Long chassiId);

}
