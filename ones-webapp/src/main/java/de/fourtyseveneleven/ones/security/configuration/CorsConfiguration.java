package de.fourtyseveneleven.ones.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // Safe to allow for api endpoints, since we use JWT tokens.
        registry.addMapping("/api/**")
                .allowedMethods("*")
                .allowedOrigins("*");
        registry.addMapping("/error")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}
