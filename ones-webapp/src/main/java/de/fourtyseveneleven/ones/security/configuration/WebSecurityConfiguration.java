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

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Safe to disable, since we use JWT tokens.
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers(
                        "/",
                        "/index.html",
                        "/api/docs/**",
                        "/api/v1/register/**",
                        "/api/v1/login")
                .permitAll()
                // All routes that do not start with 'api/' or '/api/'
                .regexMatchers(HttpMethod.GET, "^(?!\\/?api\\/).*")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.apply(new JwtTokenFilterConfigurer());
        http.authenticationProvider(jwtTokenAuthenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(15);
    }
}