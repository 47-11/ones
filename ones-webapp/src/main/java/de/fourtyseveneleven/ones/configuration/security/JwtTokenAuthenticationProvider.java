package de.fourtyseveneleven.ones.configuration.security;

import de.fourtyseveneleven.ones.model.User;
import de.fourtyseveneleven.ones.repository.UserRepository;
import de.fourtyseveneleven.ones.settings.OnesSettings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import static de.fourtyseveneleven.ones.util.MessageUtils.getExceptionMessage;

@Component
public class JwtTokenAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final String secret;

    public JwtTokenAuthenticationProvider(UserRepository userRepository, OnesSettings onesSettings) {
        this.userRepository = userRepository;

        this.secret = onesSettings.getSecurity().getJwt().getSecret();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        final JwtTokenAuthentication jwtTokenAuthentication = (JwtTokenAuthentication) authentication;
        final String rawToken = jwtTokenAuthentication.getCredentials();
        final Jws<Claims> jwtToken = validateToken(rawToken);
        final User user = getUserFromToken(jwtToken);

        return new JwtTokenAuthentication(rawToken, user);
    }

    private Jws<Claims> validateToken(String rawToken) {

        try {
            return doValidateToken(rawToken);
        } catch (ExpiredJwtException e) {
            throw new CredentialsExpiredException(getExceptionMessage("authentication.jwt.token-expired"), e);
        } catch (Exception e) {
            throw new BadCredentialsException(getExceptionMessage("authentication.jwt.token-invalid"), e);
        }
    }

    private Jws<Claims> doValidateToken(String rawToken) {

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(rawToken);
    }

    private User getUserFromToken(Jws<Claims> jwtToken) {

        final String emailAddress = getEmailAddressFromToken(jwtToken);
        return userRepository.findOneByEmailAddress(emailAddress)
                .orElseThrow(() -> new BadCredentialsException(getExceptionMessage("authentication.jwt.unknown-email-address-in-token")));
    }

    private String getEmailAddressFromToken(Jws<Claims> jwtToken) {

        return jwtToken.getBody().getSubject();
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return JwtTokenAuthentication.class.isAssignableFrom(authentication);
    }
}
