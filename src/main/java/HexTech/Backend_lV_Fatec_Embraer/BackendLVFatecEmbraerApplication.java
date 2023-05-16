package HexTech.Backend_lV_Fatec_Embraer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class BackendLVFatecEmbraerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendLVFatecEmbraerApplication.class, args);
	}
	
}
