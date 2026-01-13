package dio.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;

@OpenAPIDefinition(
		info = @Info(
				title = "Title - Rest API",
				version = "1.0",
				description = "API exemplo de uso de Spring Boot REST API",
				contact = @Contact(
						name = "Métodos Http",
						url = "https://www.metodoshttp.com.br",
						email = "test@metodoshttp.com.br"
				)
		)
)

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
