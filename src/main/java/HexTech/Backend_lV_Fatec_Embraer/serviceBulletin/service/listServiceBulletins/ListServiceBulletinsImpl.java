package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.listServiceBulletins;


import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.listServiceBulletins.dto.ListServiceBulletinsResponse;

public interface ListServiceBulletinsImpl {
	
	@PreAuthorize("hasRole('EDITOR')" + "|| hasRole('ADM')")	
	public List<ListServiceBulletinsResponse> execute(Long chassiId);

}
