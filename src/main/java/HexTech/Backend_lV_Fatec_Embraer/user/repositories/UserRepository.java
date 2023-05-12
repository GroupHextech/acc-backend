package HexTech.Backend_lV_Fatec_Embraer.user.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	Users findByUserUsername(String username);

}
