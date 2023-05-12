package HexTech.Backend_lV_Fatec_Embraer.login;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.securityconfig.JwtUtils;
import HexTech.Backend_lV_Fatec_Embraer.securityconfig.Login;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;
  
    @PostMapping
    public Login autenticar(@RequestBody Login login) throws JsonProcessingException {
    	
      Authentication auth = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
      
      auth = authManager.authenticate(auth);
      login.setPassword(login.getPassword());
      login.setToken(JwtUtils.generateToken(auth));
      login.setAutorizacao(auth.getAuthorities().iterator().next().getAuthority());
      System.out.println(JwtUtils.generateToken(auth));
      return login;
    }
}
