package HexTech.Backend_lV_Fatec_Embraer.permission.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HexTech.Backend_lV_Fatec_Embraer.permission.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{

}
