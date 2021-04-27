package de.fourtyseveneleven.ones.settings;

import de.fourtyseveneleven.ones.settings.message.MessageSettings;
import de.fourtyseveneleven.ones.settings.security.SecuritySettings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "ones")
public class OnesSettings {

    @NestedConfigurationProperty
    private final SecuritySettings security = new SecuritySettings();

    @NestedConfigurationProperty
    private final MessageSettings message = new MessageSettings();

    public SecuritySettings getSecurity() {
        return security;
    }

    public MessageSettings getMessage() {
        return message;
    }
}
