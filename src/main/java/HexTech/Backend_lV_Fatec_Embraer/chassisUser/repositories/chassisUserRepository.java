package HexTech.Backend_lV_Fatec_Embraer.chassisUser.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.chassisUser.entity.ChassisUser;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;

@Repository
public interface chassisUserRepository extends JpaRepository<ChassisUser, Long> {

	public ArrayList<ChassisUser> findByUserId(Users user);

}
