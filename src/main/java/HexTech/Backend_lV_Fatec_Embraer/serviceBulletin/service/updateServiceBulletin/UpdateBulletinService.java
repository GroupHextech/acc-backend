package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.updateServiceBulletin;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.entity.ChassisUser;
import HexTech.Backend_lV_Fatec_Embraer.chassisUser.repositories.chassisUserRepository;
import HexTech.Backend_lV_Fatec_Embraer.securityconfig.UserSession;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity.ServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.repositories.ServiceBulletinRepository;
import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.service.updateServiceBulletin.dto.ServiceBulletinUpdateDTO;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@Service
@Transactional
public class UpdateBulletinService {

	@Autowired
	private ServiceBulletinRepository serviceBulletinRepository;

	@Autowired
	private ChassiServiceBulletinRepository chassiServiceBulletinRepository;

	@Autowired
	private UserSession userSession;

	@Autowired
	private chassisUserRepository chassisuserRepository;

	@PreAuthorize("hasRole('EDITOR')" + "|| hasRole('ADM')")
	public void execute(List<ServiceBulletinUpdateDTO> serviceBulletinUpdateDTO, Long chassi_id) {

		if (serviceBulletinUpdateDTO == null || serviceBulletinUpdateDTO.isEmpty() || chassi_id == null) {
			throw new Error("ParametersNull");
		}
		
		
		Chassis chassiUpdate = new Chassis();
		chassiUpdate.setChassiId(chassi_id);

		Users user = userSession.userLoged();
		ChassisUser chassisUsers = chassisuserRepository.findByUserIdAndChassiId(user,chassiUpdate);
		if(chassisUsers == null) {
			throw new Error("UserWithoutPermission");
		}
		
		ArrayList<ChassiServiceBulletin> listChassiServiceBulletin = new ArrayList<>();

		for (ServiceBulletinUpdateDTO listServiceBulletin : serviceBulletinUpdateDTO) {
			if (listServiceBulletin.getBulletin_service_name() == null || listServiceBulletin.getPart() == null) {
				throw new Error("ServiceBulletinNameorPartNull");
			}
			ServiceBulletin serviceBulletin = serviceBulletinRepository.findByServiceBulletinNameAndServiceBulletinPart(
					listServiceBulletin.getBulletin_service_name(), listServiceBulletin.getPart());
			if (serviceBulletin == null) {
				throw new Error("ServiceBulletinNull");
			}
			ChassiServiceBulletin chassiServiceBulletin = chassiServiceBulletinRepository
					.findByChassiIdAndServiceBulletinId(chassiUpdate, serviceBulletin);
			if (listServiceBulletin.getStatus() == null) {
				throw new Error("ServiceBulletinStatusNull");
			}
			chassiServiceBulletin.setServiceBulletinStatus(listServiceBulletin.getStatus());
			chassiServiceBulletin.setUser(user);
			listChassiServiceBulletin.add(chassiServiceBulletin);
		}
		chassiServiceBulletinRepository.saveAllAndFlush(listChassiServiceBulletin);
	}
}
