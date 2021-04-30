package de.fourtyseveneleven.ones.openapi.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

import static de.fourtyseveneleven.ones.openapi.configuration.OpenApiConfiguration.BEARER_SECURITY_SCHEME_NAME;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Ones API", version = "v1"))
@SecurityScheme(
        name = BEARER_SECURITY_SCHEME_NAME,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfiguration {

    public static final String BEARER_SECURITY_SCHEME_NAME = "bearerAuth";

}