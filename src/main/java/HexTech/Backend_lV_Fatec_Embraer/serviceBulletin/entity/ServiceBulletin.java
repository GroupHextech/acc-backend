package HexTech.Backend_lV_Fatec_Embraer.serviceBulletin.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="SERVICE_BULLETIN")
public class ServiceBulletin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SB_ID")
	private Long serviceBulletinId;
	
	@Column(name="SB_NAME")
	@NotNull
	private String serviceBulletinName;
	
	@Column(name="SB_DTREGISTER")
	@UpdateTimestamp
	private Timestamp serviceBulletinDtRegister;
	
	@Column(name="SB_PARTSERVICE")
	private String serviceBulletinPart;
	
	@JoinColumn(name="USER_ID_REGISTER")
	@ManyToOne(fetch = FetchType.LAZY)
	private Users userRegister;
	
}