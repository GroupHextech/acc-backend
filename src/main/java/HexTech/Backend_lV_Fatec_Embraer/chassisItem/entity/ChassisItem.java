package HexTech.Backend_lV_Fatec_Embraer.chassisItem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import HexTech.Backend_lV_Fatec_Embraer.chassis.entity.Chassis;
import HexTech.Backend_lV_Fatec_Embraer.item.entity.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="CHASSIS_ITEM")
public class ChassisItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CHASSIS_ITEM_ID")
	private Long chassisItemId;
	
	@JoinColumn(name="CHASSI_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Chassis chassiId;
	
	@JoinColumn(name="ITEM_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Item itemId;
}
