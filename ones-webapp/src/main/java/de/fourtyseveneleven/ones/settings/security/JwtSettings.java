package de.fourtyseveneleven.ones.settings.security;

public class JwtSettings {

    private String secret;
    private long expirationDuration;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpirationDuration() {
        return expirationDuration;
    }

    public void setExpirationDuration(long expirationDuration) {
        this.expirationDuration = expirationDuration;
    }
}
