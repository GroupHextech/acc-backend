package HexTech.Backend_lV_Fatec_Embraer.login;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
	
    @Autowired(required=true)
    private AuthenticationManager authManager;
	
	@PostMapping
    public ResponseEntity<Login> autenticar(@RequestBody Login login) throws JsonProcessingException {
	      Authentication auth = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());
	      auth = authManager.authenticate(auth);
	      login.setPassword(login.getPassword());

	      return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	    }

}
