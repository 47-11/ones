package de.fourtyseveneleven.ones.settings.message;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

public class MessageSettings {

    @NestedConfigurationProperty
    private final EmailSettings email = new EmailSettings();

    public EmailSettings getEmail() {
        return email;
    }

}
