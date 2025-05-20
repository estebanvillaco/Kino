package no.usn.kino.kino.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Kino API",
                version = "1.0",
                description = "API for Kino application login and management"
        )
)
public class SwaggerConfig {
}
