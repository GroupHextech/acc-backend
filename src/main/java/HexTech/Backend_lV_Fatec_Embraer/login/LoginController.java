package HexTech.Backend_lV_Fatec_Embraer.login;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HexTech.Backend_lV_Fatec_Embraer.securityconfig.JwtUtils;
import HexTech.Backend_lV_Fatec_Embraer.user.entity.Users;
import HexTech.Backend_lV_Fatec_Embraer.user.repositories.UserRepository;


@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private UserRepository repo;

    @Autowired
    private AuthenticationManager authManager;
  
    @PostMapping()
    public Login autenticar(@RequestBody Login login) throws JsonProcessingException {
      Authentication auth = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());
      auth = authManager.authenticate(auth);
      login.setPassword(null);
      login.setToken(JwtUtils.generateToken(auth));
      login.setAuth(auth.getAuthorities().iterator().next().getAuthority());
      return login;
    }
    
    @GetMapping
    @Transactional
    public List<Users> getAll() {
    	return repo.findAll();
    }
    
}
