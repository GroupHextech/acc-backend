package HexTech.Backend_lV_Fatec_Embraer.item.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import HexTech.Backend_lV_Fatec_Embraer.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

	Item findByItemName(String name);
}
