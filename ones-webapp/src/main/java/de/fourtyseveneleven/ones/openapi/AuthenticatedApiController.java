package de.fourtyseveneleven.ones.openapi;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static de.fourtyseveneleven.ones.openapi.configuration.OpenApiConfiguration.BEARER_SECURITY_SCHEME_NAME;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@RestController
@SecurityRequirement(name = BEARER_SECURITY_SCHEME_NAME)
public @interface AuthenticatedApiController {
}
