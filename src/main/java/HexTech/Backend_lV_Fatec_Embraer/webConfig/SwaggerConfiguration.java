package HexTech.Backend_lV_Fatec_Embraer.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("HexTech.Backend_lV_Fatec_Embraer"))
				.paths(PathSelectors.any()).build();
	}
}
