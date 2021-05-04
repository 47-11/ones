package de.fourtyseveneleven.ones.security.service.impl;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.security.service.JwtTokenBuilderService;
import de.fourtyseveneleven.ones.settings.security.JwtSettings;
import de.fourtyseveneleven.ones.settings.OnesSettings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenBuilderServiceImpl implements JwtTokenBuilderService {

    private final String secret;
    private final long expirationDuration;

    public JwtTokenBuilderServiceImpl(OnesSettings onesSettings) {

        final JwtSettings jwtSettings = onesSettings.getSecurity().getJwt();
        secret = jwtSettings.getSecret();
        expirationDuration = jwtSettings.getExpirationDuration();
    }

    @Override
    public String buildToken(User user) {

        return Jwts.builder()
                .setClaims(buildJwtTokenClaims(user))
                .setIssuedAt(getIssuedAtDate())
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private Date getExpirationDate() {

        return new Date(getIssuedAtDate().getTime() + expirationDuration);
    }

    private Date getIssuedAtDate() {

        return new Date();
    }

    private Claims buildJwtTokenClaims(User user) {

        return Jwts.claims().setSubject(user.getEmailAddress());
    }
}
