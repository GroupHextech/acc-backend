package HexTech.Backend_lV_Fatec_Embraer.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;
import HexTech.Backend_lV_Fatec_Embraer.user.repositories.UserRepository;



@Service
public class UserSession {
	
	@Autowired
	UserRepository userRepository;

    public Users userLoged() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = (String) authentication.getPrincipal();
    	Users user = userRepository.findByUserUsername(username);
    	
        return user;
    }
    
}
