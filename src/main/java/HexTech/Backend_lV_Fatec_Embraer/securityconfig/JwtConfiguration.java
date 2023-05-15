package HexTech.Backend_lV_Fatec_Embraer.securityconfig;

import javax.websocket.Encoder;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class JwtConfiguration extends WebSecurityConfigurerAdapter {
	private final UserDetailsDataImpl userDetailsDataImpl;

	private final PasswordEncoder encoder;

	public JwtConfiguration(UserDetailsDataImpl userDetailsDataImpl, PasswordEncoder encoder) {
		this.userDetailsDataImpl = userDetailsDataImpl;
		this.encoder = encoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsDataImpl).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeHttpRequests().antMatchers(HttpMethod.POST, "/login").permitAll()
				.anyRequest().authenticated().and().addFilter(new JwtAuthenticationFIlter(authenticationManager()))
				.addFilter(new JwtAuthFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
