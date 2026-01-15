package dio.web.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "User API",
                version = "1.0",
                description = "API para gerenciamento de usuários",
                contact = @Contact(
                        name = "Jullya",
                        email = "jullya@email.com"
                )
        )
)
public class OpenApiConfig {
}
