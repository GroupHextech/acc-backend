package HexTech.Backend_lV_Fatec_Embraer.securityconfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtAuthenticationFIlter extends UsernamePasswordAuthenticationFilter {

	public static final String KEY = "9f0ba8ea-e985-477d-baa3-2d7f0b891657";
	
	private final AuthenticationManager authenticationManager;

	public JwtAuthenticationFIlter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Users user = new ObjectMapper().readValue(request.getInputStream(), Users.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserUsername(),
					user.getUserPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new Error("AuthenticationFailed");
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

	      Date agora = new Date();
	      Long hora = 1000L * 60L * 60L;
		
		UserDetailsData userData = (UserDetailsData) authResult.getPrincipal();
		String token = Jwts.builder().claim("userDetails", userData).setIssuer("br.gov.sp.fatec").setSubject(userData.getUsername())
		          .setExpiration(new Date(agora.getTime() + hora)).signWith(Keys.hmacShaKeyFor(KEY.getBytes()), SignatureAlgorithm.HS256).compact();
	
		response.getWriter().write(token);
		response.getWriter().flush();
	}

}
