package de.fourtyseveneleven.ones.security.util;

import de.fourtyseveneleven.ones.security.configuration.JwtTokenAuthentication;
import de.fourtyseveneleven.ones.security.exception.InvalidAuthenticationException;
import de.fourtyseveneleven.ones.user.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;

public final class UserUtils {

    private UserUtils() {
    }

    public static User getAuthenticatedUser() {

        final Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtTokenAuthentication jwtTokenAuthentication) {
            return getUserFromAuthentication(jwtTokenAuthentication);
        } else {
            throw new InvalidAuthenticationException(getExceptionMessage(
                    "authentication.invalid-authentication-type", JwtTokenAuthentication.class, authentication.getClass()));
        }
    }

    private static User getUserFromAuthentication(JwtTokenAuthentication jwtTokenAuthentication) {

        return Optional.ofNullable(jwtTokenAuthentication.getPrincipal())
                .orElseThrow(() -> new InvalidAuthenticationException(
                        getExceptionMessage("authentication.no-user-in-authentication")));
    }
}
