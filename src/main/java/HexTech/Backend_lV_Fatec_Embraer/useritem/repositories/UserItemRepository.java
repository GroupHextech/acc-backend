package HexTech.Backend_lV_Fatec_Embraer.useritem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.useritem.entity.UserItem;

@Repository
public interface UserItemRepository extends JpaRepository<UserItem, Long>{

}
