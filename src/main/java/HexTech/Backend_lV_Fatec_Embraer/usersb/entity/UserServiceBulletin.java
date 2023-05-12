package HexTech.Backend_lV_Fatec_Embraer.usersb.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity.ServiceBulletin;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="EDIT_USER_SB")
public class UserServiceBulletin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EDIT_USER_SB_ID") 
	private Long userServiceBulletinId;
	
	@JoinColumn(name="USER_ID_EDIT")
	@ManyToOne(fetch = FetchType.LAZY)
	private Users userIdRegister;
	
	@JoinColumn(name="SB_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private ServiceBulletin ServiceBulletinId;
	
}

