package HexTech.Backend_lV_Fatec_Embraer.chassis.service.contadorChassiBySb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassis.repositories.ChassisRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassis.service.contadorChassiBySb.dto.ContadorChassisBySbDto;
import HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassiByItems.util.ChassiContainItem;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.repositories.chassisUserRepository;
import HexTech.Backend_lV_Fatec_Embraer.item.services.contagemItens.dto.ChassisBySbDto;
import HexTech.Backend_lV_Fatec_Embraer.securityconfig.UserSession;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity.ServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.repositories.ServiceBulletinRepository;

@Service
public class ContadorChassisBySbService {
	
	@Autowired
	ChassisRepository chassisRepository;
	
	@Autowired
	chassisUserRepository chassisUserRepository;
	
	@Autowired
	ServiceBulletinRepository serviceBulletinRepository;

	@Autowired
	ChassiServiceBulletinRepository chassiServiceBulletinRepository;
	
	@Autowired
	UserSession session;

	@Autowired
	ChassiContainItem chassiContainItem;

	@PreAuthorize("hasRole('ADM')")
	public ContadorChassisBySbDto execute(String sbName, String part) {
		
		List<Chassis> allChassis = chassisRepository.findAll();
		
		ContadorChassisBySbDto contadorChassisBySbDto = new ContadorChassisBySbDto();
						
		ServiceBulletin serviceBulletin = new ServiceBulletin();
		serviceBulletin.setServiceBulletinName(sbName);
		
		List<ChassiServiceBulletin> chassi = chassiServiceBulletinRepository.findByServiceBulletinId(serviceBulletinRepository.findByServiceBulletinNameAndServiceBulletinPart(sbName, part));
		
		List<ChassisBySbDto> chassisList = new ArrayList<ChassisBySbDto>();

		for (ChassiServiceBulletin chassiId : chassi) {
			ChassisBySbDto chassisBySbDto = new ChassisBySbDto();
			chassisBySbDto.setChassi(chassiId.getChassiId().getChassiId());
			chassisList.add(chassisBySbDto);
		}
		Integer countChassis = chassisList.size();
		contadorChassisBySbDto.setTotal_chassi(allChassis.size());
		contadorChassisBySbDto.setChassis(chassisList);
		contadorChassisBySbDto.setCount_chassi(countChassis);
		contadorChassisBySbDto.setServiceBulletin(sbName);
		contadorChassisBySbDto.setPart(part);
		return contadorChassisBySbDto;
	}

}
