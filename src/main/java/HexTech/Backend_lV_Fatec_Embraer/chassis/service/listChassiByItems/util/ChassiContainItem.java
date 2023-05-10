package HexTech.Backend_lV_Fatec_Embraer.chassis.service.listChassiByItems.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;

@Service
public class ChassiContainItem {

	@Autowired
	ChassiServiceBulletinRepository chassiServiceBulletinRepository;

	public List<Long> containItem(List<Long> chassiIds, String name) {

		List<Long> chassiIdContain = new ArrayList<>();

		if (name.equals("vidrosetravaseletricas")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-21-CG12")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}

		else if (name.equals("arcondicionado")) {

			for (Long chassiId : chassiIds) {
				
				if (chassiId > 10000123) {
					chassiIdContain.add(chassiId);
				}
			}
		}
		else if (name.equals("direçao")) {

			for (Long chassiId : chassiIds) {
				
				if (chassiId > 10000450) {
					chassiIdContain.add(chassiId);
				}
			}
		}
		
		else if (name.equals("airbagsfrontais")) {

			for (Long chassiId : chassiIds) {
				
				if (chassiId >= 10000196) {
					chassiIdContain.add(chassiId);
				}
			}
		}
		else if (name.equals("airbagslaterais")) {

			for (Long chassiId : chassiIds) {
				
				if (chassiId > 10000621) {
					chassiIdContain.add(chassiId);
				}
			}
		}
		
		else if (name.equals("gps")) {

			for (Long chassiId : chassiIds) {
				
				if (chassiId > 10000012) {
					chassiIdContain.add(chassiId);
				}
			}
		}
		
		else if (name.equals("sistemamultimida")) {

			for (Long chassiId : chassiIds) {
				
				if (chassiId > 10000035) {
					chassiIdContain.add(chassiId);
				}
			}
		}
		
		else if (name.equals("estepe")) {

			for (Long chassiId : chassiIds) {
				
				if (chassiId > 10000078) {
					chassiIdContain.add(chassiId);
				}
			}
		}
		
		else if (name.equals("bancodecouro")) {

			for (Long chassiId : chassiIds) {
				
				if (chassiId > 100000017) {
					chassiIdContain.add(chassiId);
				}
			}
		}
		
		else if (name.equals("sistemamodernizadodesom")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-23-CG01")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("cruisecontrol")) {
			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				List<String> sbName = new ArrayList<>();
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					sbName.add(chassiService.getServiceBulletinId().getServiceBulletinName());
				}
				if(sbName.contains("SB FAT-23-CG04") || 
						sbName.contains("SB FAT-23-CG05") && 
							sbName.contains("SB FAT-31-CG05")) {
					chassiIdContain.add(chassiId);
				}
			}

		}
		
		else if (name.equals("sensordeproximidade")) {
			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				List<String> sbName = new ArrayList<>();
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					sbName.add(chassiService.getServiceBulletinId().getServiceBulletinName());
				}
				if(sbName.contains("SB FAT-23-CG06") && 
							sbName.contains("SB FAT-31-CG08")) {
					chassiIdContain.add(chassiId);
				}
			}

		}
		
		else if (name.equals("calhadechuva")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-23-CG08")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("controledetraçao")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-23-CG02")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("pinturaanti-corrosao")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-23-CG03")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("funcaoeconomicsport")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-25-CG23")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("bluetooth")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-25-CG30")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("cameratraseira")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-25-CG04")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("freioabs")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-25-CG31")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("vidroscomfechamentoemumtoque")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-27-CG11")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("partidaremota")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-27-CG18")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("aquecimentonosbancos")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-30-CG04")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}

		else if (name.equals("controledeestabilidade")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-31-CG03")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("rodadeligaleve")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-31-CG19")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("cambioautomatico")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-31-CG02")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		
		else if (name.equals("faroldeneblina")) {

			for (Long chassiId : chassiIds) {
				Chassis chassi = new Chassis();
				chassi.setChassiId(chassiId);
				List<ChassiServiceBulletin> bulletinsNames = chassiServiceBulletinRepository.findByChassiId(chassi);
				for (ChassiServiceBulletin chassiService : bulletinsNames) {
					if (chassiService.getServiceBulletinId().getServiceBulletinName().equals("SB FAT-34-CG23")) {
						chassiIdContain.add(chassiId);
					}
				}
			}

		}
		return chassiIdContain;
	}

}
