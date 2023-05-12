package HexTech.Backend_lV_Fatec_Embraer.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;
import HexTech.Backend_lV_Fatec_Embraer.user.repositories.UserRepository;

@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private UserRepository usuarioRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users usuario = usuarioRepo.findByUserUsername(username);
		if (usuario == null) {
			throw new Error("Credentials error");
		}
		return User.builder().username(username).password(usuario.getUserPassword())
				.authorities(usuario.getPermissionId().getPermissionName()).build();
	}
}
