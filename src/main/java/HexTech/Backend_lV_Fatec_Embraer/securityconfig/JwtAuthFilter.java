package HexTech.Backend_lV_Fatec_Embraer.securityconfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import lombok.NoArgsConstructor;

public class JwtAuthFilter extends BasicAuthenticationFilter{
	
	public static final String HEADER_ATRIBUTO = "Authorization";
	
	public static final String ATRIBUTO_PREFIXO = "Bearer ";

	public JwtAuthFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}


	//@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String atributo = request.getHeader(HEADER_ATRIBUTO);
		
		if(atributo == null) {
			chain.doFilter(request, response);
			return;
		}
		
		if(atributo.startsWith(ATRIBUTO_PREFIXO)) {
			chain.doFilter(request, response);
			return;
		}
        
		String token = atributo.replace(ATRIBUTO_PREFIXO, "");
		UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token, request);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthenticationToken(String token, HttpServletRequest request) {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String authorization = servletRequest.getHeader(HttpServletRequest.BASIC_AUTH);
		
		return new UsernamePasswordAuthenticationToken(servletRequest, authorization);
	}
	
}
