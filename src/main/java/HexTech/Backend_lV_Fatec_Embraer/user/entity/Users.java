package HexTech.Backend_lV_Fatec_Embraer.user.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import HexTech.Backend_lV_Fatec_Embraer.permission.entity.Permission;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="USUARIOS")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_USERNAME")
	private String userUsername;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name = "USER_STATUS")
	private Character userStatus;
	
	
	@JoinColumn(name="PERMISSION_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Permission permissionId;
	
}
