package de.fourtyseveneleven.ones.settings.security;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

public class SecuritySettings {


    @NestedConfigurationProperty
    private final JwtSettings jwt = new JwtSettings();

    public JwtSettings getJwt() {
        return jwt;
    }
}
