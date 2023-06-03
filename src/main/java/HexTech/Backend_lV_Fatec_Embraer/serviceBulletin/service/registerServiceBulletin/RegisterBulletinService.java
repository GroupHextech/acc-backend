package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.registerServiceBulletin;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassis.repositories.ChassisRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.securityconfig.UserSession;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity.ServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.repositories.ServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.registerServiceBulletin.dto.ServiceBulletinRegisterDTO;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.registerServiceBulletin.dto.VerifyDTO;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.registerServiceBulletin.util.VerifyPart;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@Service
@Transactional
public class RegisterBulletinService {

	@Autowired
	private ServiceBulletinRepository serviceBulletinRepository;

	@Autowired
	private ChassisRepository chassisRepository;

	@Autowired
	private ChassiServiceBulletinRepository chassiServiceBulletinRepository;

	@Autowired
	private VerifyPart verifyPart;
	
	@Autowired
	private UserSession userSession;

	@PreAuthorize("hasRole('EDITOR')" + "|| hasRole('ADM')")	
	public void execute(List<ServiceBulletinRegisterDTO> serviceBulletinRegisterDTO) {

		Users userLoged = userSession.userLoged();
		
		List<ChassiServiceBulletin> service = new ArrayList<>();

		for (ServiceBulletinRegisterDTO serviceDTO : serviceBulletinRegisterDTO) {

			Chassis exist = chassisRepository.findById(serviceDTO.getChassis()).orElse(null);

			if (exist == null) {

				char status = 'A';
				
				Chassis chassis = new Chassis();
				
				chassis.setChassiId(serviceDTO.getChassis());
				chassis.setChassiStatus(status);
				chassis.setUserRegister(userLoged);
				
				chassisRepository.saveAndFlush(chassis);
				
			}

			VerifyDTO serviceInfo = verifyPart.verifyPart(serviceDTO.getBulletin_service());

			ServiceBulletin serviceBulletin = serviceBulletinRepository
					.findByServiceBulletinNameAndServiceBulletinPart(serviceInfo.getBulletin(), serviceInfo.getPart());
			
			
			if(serviceBulletin == null) {
				ServiceBulletin newServiceBulletin = new ServiceBulletin();
				newServiceBulletin.setServiceBulletinName(serviceInfo.getBulletin());
				newServiceBulletin.setServiceBulletinPart(serviceInfo.getPart());
				ServiceBulletin serviceBulletinRegistered = serviceBulletinRepository.saveAndFlush(newServiceBulletin);
				

				Chassis chassiExist = new Chassis();
				chassiExist.setChassiId(serviceDTO.getChassis());
				
				ChassiServiceBulletin chassiServiceBulletin = new ChassiServiceBulletin();
				chassiServiceBulletin.setChassiId(chassiExist);
				chassiServiceBulletin.setServiceBulletinId(serviceBulletinRegistered);
				chassiServiceBulletin.setServiceBulletinStatus(serviceDTO.getStatus());
				chassiServiceBulletin.setUser(userLoged);
				service.add(chassiServiceBulletin);
			}else {
			
			Chassis chassiExist = new Chassis();
			chassiExist.setChassiId(serviceDTO.getChassis());
			
			ChassiServiceBulletin chassiServiceBulletin = new ChassiServiceBulletin();
			chassiServiceBulletin.setChassiId(chassiExist);
			chassiServiceBulletin.setServiceBulletinId(serviceBulletin);
			chassiServiceBulletin.setServiceBulletinStatus(serviceDTO.getStatus());
			chassiServiceBulletin.setUser(userLoged);
			service.add(chassiServiceBulletin);
			}
		}
		chassiServiceBulletinRepository.saveAllAndFlush(service);


	}
}

