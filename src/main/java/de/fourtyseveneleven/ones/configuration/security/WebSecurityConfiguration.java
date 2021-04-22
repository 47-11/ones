package de.fourtyseveneleven.ones.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationProvider databaseAuthenticationProvider;

    public WebSecurityConfiguration(AuthenticationProvider databaseAuthenticationProvider) {
        this.databaseAuthenticationProvider = databaseAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/api/v1/example/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/swagger-ui.css",
                        "/swagger-ui-bundle.js",
                        "/swagger-ui-standalone-preset.js")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.httpBasic();

        http.authenticationProvider(databaseAuthenticationProvider);
    }
}