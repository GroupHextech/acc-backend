package HexTech.Backend_lV_Fatec_Embraer.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;
import HexTech.Backend_lV_Fatec_Embraer.user.repositories.UserRepository;

@Component
public class UserDetailsDataImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetailsDataImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> userOpt = userRepository.findByUserUsername(username);
		if(userOpt.isEmpty()) {
			throw new Error("Credentials invalid");
		}
		return new UserDetailsData(userOpt);
	}


}
