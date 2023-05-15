package HexTech.Backend_lV_Fatec_Embraer.securityconfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;
import lombok.Data;

@Data
public class UserDetailsData implements UserDetails {

	private final Optional<Users> users;

	public UserDetailsData(Optional<Users> users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return users.orElse(new Users()).getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return users.orElse(new Users()).getUserUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
