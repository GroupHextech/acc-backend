package HexTech.Backend_lV_Fatec_Embraer.formula.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import HexTech.Backend_lV_Fatec_Embraer.item.entity.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="FORMULA")
public class Formula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FORMULA_ID")
	private Long formulaId;

	@Column(name="FORMULA_DESC")
	private String formulaDescription;
	
	@JoinColumn(name="ITEM_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Item itemId;
	
}
