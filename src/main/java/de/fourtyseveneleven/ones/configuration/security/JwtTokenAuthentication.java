package de.fourtyseveneleven.ones.configuration.security;

import de.fourtyseveneleven.ones.model.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.io.Serial;
import java.util.Collections;

public class JwtTokenAuthentication extends AbstractAuthenticationToken {

    @Serial
    private static final long serialVersionUID = 5344481881136148494L;

    private final String jwtToken;
    private final User user;

    public JwtTokenAuthentication(String jwtToken) {
        super(Collections.emptyList());

        this.jwtToken = jwtToken;
        this.user = null;

        this.setAuthenticated(false);
    }

    public JwtTokenAuthentication(String jwtToken, User user) {
        super(Collections.emptyList());

        this.jwtToken = jwtToken;
        this.user = user;

        this.setAuthenticated(true);
    }

    @Override
    public String getCredentials() {
        return jwtToken;
    }

    @Override
    public User getPrincipal() {
        return user;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof JwtTokenAuthentication) {
            return super.equals(obj);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
