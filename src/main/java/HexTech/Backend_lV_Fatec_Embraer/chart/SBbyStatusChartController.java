package HexTech.Backend_lV_Fatec_Embraer.chart;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.chassis.repositories.ChassisRepository;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.entity.ChassiServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.chassisSb.repository.ChassiServiceBulletinRepository;

@RestController
@RequestMapping(value = "/chart")
public class SBbyStatusChartController {

	private final ChassiServiceBulletinRepository chassiSbRepository;
	private final ChassisRepository chassisRepository;

	public SBbyStatusChartController(ChassiServiceBulletinRepository chassiSbRepository, ChassisRepository chassisRepository) {
		this.chassiSbRepository = chassiSbRepository;
		this.chassisRepository = chassisRepository;
	}
	
	private String longToString(Long number) {
	    return number != null ? number.toString() : null;
	}
	
	@CrossOrigin
	@GetMapping("/sb-by-status")
	public ChartData getChartData() {
		ChartData chartData = new ChartData();

		// Get all chassis from the database
		List<Chassis> chassisList = chassisRepository.findAll();

		// Set labels for each chassis
		String[] labels = chassisList.stream().map(chassis -> longToString(chassis.getChassiId())).toArray(String[]::new);
		chartData.setLabels(labels);
		
		// Set datasets for each service bulletin status
		Dataset[] datasets = new Dataset[]{
				new Dataset("Incorporated", "green", getCountsByStatus(chassisList, "INCORPORATED")),
				new Dataset("Applicable", "yellow", getCountsByStatus(chassisList, "APPLICABLE")),
				new Dataset("Not Applicable", "red", getCountsByStatus(chassisList, "NOT APPLICABLE"))
		};
		chartData.setDatasets(datasets);

		return chartData;
	}
	 // Helper method to count the number of service bulletins for each chassis and status
    private int[] getCountsByStatus(List<Chassis> chassisList, String status) {
        int[] counts = new int[chassisList.size()];

        for (int i = 0; i < chassisList.size(); i++) {
            Chassis chassis = chassisList.get(i);
            List<ChassiServiceBulletin> chassiSbList = chassiSbRepository.findByChassiId(chassis);

            // Normalize the status values
            List<String> normalizedStatus = chassiSbList.stream()
                    .map(ChassiServiceBulletin::getServiceBulletinStatus)
                    .map(s -> {
                        if (s.equalsIgnoreCase("INCORPORATED") 
                        		|| s.equalsIgnoreCase("INCOPORATED") 
                        		|| s.equalsIgnoreCase("INCORP")) {
                            return "INCORPORATED";
                        } else {
                            return s;
                        }
                    })
                    .collect(Collectors.toList());

            // Count the number of normalized status values
            int count = (int) normalizedStatus.stream().filter(s -> s.equals(status)).count();
            counts[i] = count;
        }

        return counts;
    }
}

@Getter
@Setter
class ChartData {
	private String[] labels;
	private Dataset[] datasets;
}

@Getter
@Setter
class Dataset {
	private String label;
	private String backgroundColor;
	private int[] data;

	public Dataset(String label, String backgroundColor, int[] data) {
		this.label = label;
		this.backgroundColor = backgroundColor;
		this.data = data;
	}
}