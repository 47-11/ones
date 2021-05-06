package de.fourtyseveneleven.ones.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenAuthenticationProvider jwtTokenAuthenticationProvider;

    public WebSecurityConfiguration(JwtTokenAuthenticationProvider jwtTokenAuthenticationProvider) {
        this.jwtTokenAuthenticationProvider = jwtTokenAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        authorizeRequests(http);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Safe to disable, since we use JWT tokens.
        http.csrf().disable();

        http.apply(new JwtTokenFilterConfigurer());
        http.authenticationProvider(jwtTokenAuthenticationProvider);
    }

    private void authorizeRequests(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // Pre-flight requests do not need authentication
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                // These special API endpoints do not need authentication
                .antMatchers(
                        "/api/v1/register",
                        "/api/v1/register/confirm",
                        "/api/v1/login",
                        "/api/v1/forgot-password",
                        "/api/v1/forgot-password/change-password",
                        "/api/docs/**")
                .permitAll()
                // All other API endpoints need authentication
                .antMatchers("/api/**")
                .authenticated()
                // All other paths can be accessed without authentication
                .anyRequest()
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(15);
    }
}